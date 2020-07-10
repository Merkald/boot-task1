package spring.boot.task1.boottask1.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.repository.ReviewRepository;
import spring.boot.task1.boottask1.service.PickingService;
import spring.boot.task1.boottask1.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
    private static final String NOT_WORDS_REGEXP = "\\W+";
    private static final String NUMBERS_REGEXP = "[0-9]+";

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PickingService pickingService;

    @Override
    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> getByField(Review example) {
        Example<Review> review = Example.of(example);
        return reviewRepository.findOne(review);
    }

    @Override
    public List<Review> getAllByField(Review example) {
        Example<Review> review = Example.of(example);
        return reviewRepository.findAll(review);
    }

    @Override
    public void delete(Review example) {
        reviewRepository
                .deleteById(getByField(example)
                        .orElseThrow(() -> new EntityNotFoundException("Entity with current "
                                + "fields are not in DB"))
                        .getId());
    }

    @Override
    public List<String> getMostUsedWords(int amount) {
        List<String> lines = getAllByField(new Review())
                .stream()
                .map(Review::getText)
                .flatMap(x -> Arrays.stream(x.split(NOT_WORDS_REGEXP)))
                .flatMap(x -> Arrays.stream(x.split(NUMBERS_REGEXP)))
                .filter(x -> x.length() > 2)
                .collect(Collectors.toList());
        List<String> words = lines
                .stream()
                .distinct()
                .collect(Collectors.toList());
        List<Integer> popularity = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            int finalI = i;
            int count = (int) lines
                    .stream()
                    .filter(x -> x.equals(words.get(finalI)))
                    .count();
            popularity.add(count);
        }
        return pickingService.findTopQuantity(amount, words, popularity);
    }
}
