package spring.boot.task1.boottask1.service;

import spring.boot.task1.boottask1.model.User;
import java.util.Optional;

public interface UserService {
    void create(User user);

    Optional<User> getByField(User profileName);
}
