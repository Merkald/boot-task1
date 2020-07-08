package spring.boot.task1.boottask1.service;

import java.util.Optional;
import spring.boot.task1.boottask1.model.User;

public interface UserService {
    void create(User user);

    Optional<User> getByField(User profileName);
}
