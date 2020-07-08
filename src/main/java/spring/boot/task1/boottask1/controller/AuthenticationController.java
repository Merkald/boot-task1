package spring.boot.task1.boottask1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.task1.boottask1.maper.UserMaper;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.model.dto.request.UserRequestDto;
import spring.boot.task1.boottask1.security.AuthenticationService;

@RestController
@RequestMapping("register")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserMaper userMaper;

    @PostMapping
    public void register(@RequestBody UserRequestDto userRequestDto) {
        User user = userMaper.convertUser(userRequestDto);
        authenticationService.register(user);
    }
}
