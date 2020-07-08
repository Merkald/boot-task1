package spring.boot.task1.boottask1.service;

import java.util.List;
import java.util.Optional;
import spring.boot.task1.boottask1.model.User;

public interface UserService {
    User create(User user);

    Optional<User> getByField(User example);

    List<String> findMostActive(int amount);
}
