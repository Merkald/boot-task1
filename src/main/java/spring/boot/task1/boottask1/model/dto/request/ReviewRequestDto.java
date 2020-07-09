package spring.boot.task1.boottask1.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReviewRequestDto {
    private Long id;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private Long time;
    private String summary;
    private String text;
    private String profileName;
    private String profileId;
    private String productId;
}
