package spring.boot.task1.boottask1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.task1.boottask1.maper.ReviewMaper;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.model.dto.request.ReviewRequestDto;
import spring.boot.task1.boottask1.model.dto.response.ReviewResponseDto;
import spring.boot.task1.boottask1.service.ReviewService;
import spring.boot.task1.boottask1.service.UserService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewMaper reviewMaper;
    @Autowired
    private UserService userService;

    @GetMapping("/words")
    public List<String> getMostPopularWords(@RequestParam int amount) {
        return reviewService.getMostUsedWords(amount);
    }

    @DeleteMapping
    public void deleteReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        reviewService.delete(reviewMaper.convert(reviewRequestDto));
    }

    @PostMapping
    public ReviewResponseDto addReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        Review review = reviewMaper.convert(reviewRequestDto);
        return reviewMaper.convert(reviewService.create(review));
    }

    @PutMapping
    public ReviewResponseDto updateReview(@RequestBody ReviewRequestDto reviewRequestDto) {
        Review review = reviewMaper.convert(reviewRequestDto);
        Review fromDb = reviewService.getByField(review).orElseThrow();
        fromDb.setTime(review.getTime())
                .setSummary(review.getSummary())
                .setScore(review.getScore())
                .setHelpfulnessNumerator(review.getHelpfulnessNumerator())
                .setHelpfulnessDenominator(review.getHelpfulnessDenominator())
                .setText(review.getText());
        return reviewMaper.convert(reviewService.create(fromDb));
    }
}
