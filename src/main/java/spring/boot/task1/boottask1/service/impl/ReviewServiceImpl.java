package spring.boot.task1.boottask1.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.repository.ReviewRepository;
import spring.boot.task1.boottask1.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getByField(Review example) {
        Example<Review> review = Example.of(example);
        return reviewRepository.findOne(review);
    }
}
