package spring.boot.task1.boottask1.service;

import java.util.List;
import java.util.Optional;
import spring.boot.task1.boottask1.model.Review;

public interface ReviewService {
    Review create(Review user);

    Optional<Review> getByField(Review example);

    public List<Review> getAllByField(Review example);

    List<String> getMostUsedWords(int amount);

    void delete(Review example);
}
