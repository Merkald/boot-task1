package spring.boot.task1.boottask1.service;

import java.util.Optional;
import spring.boot.task1.boottask1.model.Review;

public interface ReviewService {
    void create(Review user);

    Optional<Review> getByField(Review example);
}
