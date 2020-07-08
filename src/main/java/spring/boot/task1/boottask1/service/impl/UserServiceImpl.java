package spring.boot.task1.boottask1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.repository.UserRepository;
import spring.boot.task1.boottask1.service.ReviewService;
import spring.boot.task1.boottask1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewService reviewService;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getByField(User example) {
        Example<User> userExample = Example.of(example);
        return userRepository.findOne(userExample);
    }

    @Override
    public List<String> findMostActive(int amount) {
        List<String> logins = reviewService.getAllByField(new Review())
                .stream()
                .map(Review::getProfileName)
                .distinct()
                .collect(Collectors.toList());
        List<Integer> activity = logins
                .stream()
                .map(str -> reviewService.getAllByField(new Review().setProfileName(str)).size())
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int max = activity
                    .stream()
                    .max(Integer::compareTo)
                    .orElseThrow();
            int indexOfMax = activity.indexOf(max);
            result.add(logins.get(indexOfMax));
            logins.remove(indexOfMax);
            activity.remove(indexOfMax);
        }
        return result;
    }
}
