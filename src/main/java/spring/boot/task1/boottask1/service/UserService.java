package spring.boot.task1.boottask1.service;

import java.util.List;
import java.util.Optional;
import spring.boot.task1.boottask1.model.User;

public interface UserService {
    void create(User user);

    Optional<User> geyById(Long id);

    Optional<User> getByLogin(String login);

    List<User> getAll();
}
