package spring.boot.task1.boottask1.controller;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/id:{userId}")
    public User getById(@PathVariable(name = "userId") Long id) {
        return userService.geyById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id:"
                        + id + " doesnt exist"));
    }

    @GetMapping("/login:{login}")
    public User getByLogin(@PathVariable(name = "login") String login) {
        return userService.getByLogin(login)
                .orElseThrow(() -> new EntityNotFoundException("User with login:"
                        + login + " doesnt exist"));
    }

    @PostMapping
    public void register(@RequestBody User user) {
        userService.create(user);
    }
}
