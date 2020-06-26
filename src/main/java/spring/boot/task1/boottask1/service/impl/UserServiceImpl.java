package spring.boot.task1.boottask1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.repository.UserRepository;
import spring.boot.task1.boottask1.service.UserService;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getById(String id) {
        Example<User> user = Example.of(new User().withId(id));
        return userRepository.findOne(user);
    }

    @Override
    public Optional<User> getByProfileName(String profileName) {
        Example<User> user = Example.of(new User().withProfileName(profileName));
        return userRepository.findOne(user);
    }
}
