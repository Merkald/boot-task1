package spring.boot.task1.boottask1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.task1.boottask1.maper.UserMaper;
import spring.boot.task1.boottask1.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/activity")
    public List<String> getMostActiveUsers(@RequestParam int amount) {
        List<String> list = userService.findMostActive(amount);
        return list;
    }
}
