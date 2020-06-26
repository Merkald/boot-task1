package spring.boot.task1.boottask1.model;

import lombok.Data;

@Data
public class CsvGroupedDates {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private Long time;
    private String summary;
    private String text;
}
