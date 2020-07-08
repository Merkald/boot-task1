package spring.boot.task1.boottask1.service;

import spring.boot.task1.boottask1.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> getByField(User example);

    List<String> findMostActive(int amount);
}
