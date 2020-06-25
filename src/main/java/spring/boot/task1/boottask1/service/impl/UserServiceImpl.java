package spring.boot.task1.boottask1.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.repository.UserRepository;
import spring.boot.task1.boottask1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> geyById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getByLogin(String login) {
        Example<User> example = Example.of(new User().insertLogin(login));
        return userRepository.findOne(example);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
