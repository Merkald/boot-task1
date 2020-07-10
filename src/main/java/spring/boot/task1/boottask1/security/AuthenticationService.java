package spring.boot.task1.boottask1.security;

import spring.boot.task1.boottask1.model.User;

public interface AuthenticationService {
    User register(User user);
}
