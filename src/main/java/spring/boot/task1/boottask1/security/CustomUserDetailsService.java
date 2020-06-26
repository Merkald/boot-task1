package spring.boot.task1.boottask1.security;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        spring.boot.task1.boottask1.model.User user = userService.getByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("User with login:"
                        + login + " doesnt exist"));
        User.UserBuilder builder = User.withUsername(login);
        builder.password(user.getPassword());
        builder.roles("USER");
        return builder.build();
    }
}
