package spring.boot.task1.boottask1.maper;

import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.model.dto.request.ReviewRequestDto;
import spring.boot.task1.boottask1.model.dto.response.ReviewResponseDto;

public interface ReviewMaper {

    Review convert(ReviewRequestDto reviewRequestDto);

    ReviewResponseDto convert(Review review);

}
