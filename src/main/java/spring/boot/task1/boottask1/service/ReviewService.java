package spring.boot.task1.boottask1.service;

import spring.boot.task1.boottask1.model.Review;
import java.util.Optional;

public interface ReviewService {
    void create(Review user);

    Optional<Review> getByField(Review example);
}
