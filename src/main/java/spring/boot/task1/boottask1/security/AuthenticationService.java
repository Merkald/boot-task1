package spring.boot.task1.boottask1.security;

import spring.boot.task1.boottask1.model.User;
import java.util.Optional;

public interface AuthenticationService {
    User register(User user);
}
