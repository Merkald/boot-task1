package spring.boot.task1.boottask1.model;

import lombok.Data;

@Data
public class CsvGroupedDates {
    Long id;
    String productId;
    String userId;
    String profileName;
    Long helpfulnessNumerator;
    Long helpfulnessDenominator;
    Long score;
    Long time;
    String summary;
    String text;
}
