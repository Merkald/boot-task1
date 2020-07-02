package spring.boot.task1.boottask1.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private LocalDateTime time;
    private String summary;
    @Column(length = 50000)
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Review withId(Long id) {
        this.id = id;
        return this;
    }

    public Review withHelpfulnessNumerator(int helpfulnessNumerator) {
        this.helpfulnessNumerator = helpfulnessNumerator;
        return this;
    }

    public Review withHelpfulnessDenominator(int helpfulnessDenominator) {
        this.helpfulnessDenominator = helpfulnessDenominator;
        return this;
    }

    public Review withScore(int score) {
        this.score = score;
        return this;
    }

    public Review withTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public Review withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public Review withText(String text) {
        this.text = text;
        return this;
    }

    public Review withUser(User user) {
        this.user = user;
        return this;
    }

    public Review withProduct(Product product) {
        this.product = product;
        return this;
    }
}
