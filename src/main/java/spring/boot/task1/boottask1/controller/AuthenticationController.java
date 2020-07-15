package spring.boot.task1.boottask1.controller;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.task1.boottask1.maper.UserMaper;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.model.dto.request.UserRequestDto;
import spring.boot.task1.boottask1.security.AuthenticationService;
import spring.boot.task1.boottask1.security.impl.jwt.JwtTokenProvider;

@RestController
@RequestMapping("register")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserMaper userMaper;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public void register(@RequestBody UserRequestDto userRequestDto) {
        User user = userMaper.convertUser(userRequestDto);
        authenticationService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserRequestDto userLoginDto) {
        User user = authenticationService.login(userLoginDto.getLogin(),
                userLoginDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getLogin(), user.getRoles().stream()
                .map(role -> role.getRoleName().name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
