package spring.boot.task1.boottask1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.boot.task1.boottask1.security.impl.jwt.JwtConfigurer;
import spring.boot.task1.boottask1.security.impl.jwt.JwtTokenProvider;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/register", "/login", "/swagger-resources/**",
                        "/swagger-ui.html")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/reviews/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/reviews/**")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/reviews/**")
                .hasRole("USER")
                .antMatchers(HttpMethod.GET, "/reviews/words", "/products", "/users")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .and()
                .httpBasic()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider))
                .and()
                .headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
