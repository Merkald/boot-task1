package spring.boot.task1.boottask1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.model.Role;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.service.ReviewService;
import spring.boot.task1.boottask1.service.RoleService;
import spring.boot.task1.boottask1.service.UserService;
import spring.boot.task1.boottask1.service.impl.CsvFileParserService;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

@Controller
public class InjectController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CsvFileParserService csvFileParserService;
    @Autowired
    private ReviewService reviewService;

    @PostConstruct
    public void inject() {
        String path = "reviews.csv";
        injectRoles();
        injectUsers();
        injectDatesFromFile(csvFileParserService.parseFile(path));
    }

    private void injectUsers() {
        User admin = new User();
        admin.setLogin("admin");
        admin.setRoles(Set.of(roleService
                .getByField(new Role().setRoleName(Role.RoleName.ADMIN)).orElseThrow()));
        admin.setPassword("1234");
        User user = new User();
        user.setLogin("user");
        user.setRoles(Set.of(roleService
                .getByField(new Role().setRoleName(Role.RoleName.USER)).orElseThrow()));
        user.setPassword("1234");
        userService.create(admin);
        userService.create(user);
    }

    private void injectRoles() {
        roleService.create(new Role().setRoleName(Role.RoleName.ADMIN));
        roleService.create(new Role().setRoleName(Role.RoleName.USER));
    }

    private void injectDatesFromFile(List<Review> list) {
        for (Review review : list) {
            reviewService.create(review);
        }
    }
}
