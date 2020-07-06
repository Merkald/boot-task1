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
    public Optional<User> getByField(User user) {
        Example<User> example = Example.of(user);
        return userRepository.findOne(example);
    }
}
