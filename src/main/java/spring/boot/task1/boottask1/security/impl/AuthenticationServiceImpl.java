package spring.boot.task1.boottask1.security.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Role;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.security.AuthenticationService;
import spring.boot.task1.boottask1.service.RoleService;
import spring.boot.task1.boottask1.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public User register(User user) {
        user.getRoles().add(roleService
                .getByField(new Role().setRoleName(Role.RoleName.USER)).orElseThrow());
        return userService.create(user);
    }
}
