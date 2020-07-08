package spring.boot.task1.boottask1.maper.impl;

import org.springframework.stereotype.Component;
import spring.boot.task1.boottask1.maper.ReviewMaper;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.model.dto.request.ReviewRequestDto;
import spring.boot.task1.boottask1.model.dto.response.ReviewResponseDto;

@Component
public class ReviewMaperImpl implements ReviewMaper {
    @Override
    public Review convert(ReviewRequestDto reviewRequestDto) {
        return new Review()
                .setProfileName(reviewRequestDto.getProfileName())
                .setText(reviewRequestDto.getText())
                .setProfileId(reviewRequestDto.getProfileId())
                .setProductId(reviewRequestDto.getProductId())
                .setHelpfulnessDenominator(reviewRequestDto.getHelpfulnessDenominator())
                .setHelpfulnessNumerator(reviewRequestDto.getHelpfulnessNumerator())
                .setId(reviewRequestDto.getId())
                .setScore(reviewRequestDto.getScore())
                .setSummary(reviewRequestDto.getSummary())
                .setTime(reviewRequestDto.getTime());
    }

    @Override
    public ReviewResponseDto convert(Review review) {
        return new ReviewResponseDto()
                .setProfileName(review.getProfileName())
                .setText(review.getText())
                .setProfileId(review.getProfileId())
                .setProductId(review.getProductId())
                .setHelpfulnessDenominator(review.getHelpfulnessDenominator())
                .setHelpfulnessNumerator(review.getHelpfulnessNumerator())
                .setId(review.getId())
                .setScore(review.getScore())
                .setSummary(review.getSummary())
                .setTime(review.getTime());
    }
}
