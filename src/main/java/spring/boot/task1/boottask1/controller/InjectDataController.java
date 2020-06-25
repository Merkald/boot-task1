package spring.boot.task1.boottask1.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.service.UserService;

@RestController
@RequestMapping("/inject")
public class InjectDataController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void injectData() {
        injectUser();
    }

    private void injectUser() {
        User user = new User()
                .insertLogin("q")
                .insertPassword("q");
        userService.create(user);
        for (int i = 0; i < 3; i++) {
            user = new User()
                    .insertLogin("login_" + i)
                    .insertPassword("password_" + i);
            userService.create(user);
        }
    }

}
