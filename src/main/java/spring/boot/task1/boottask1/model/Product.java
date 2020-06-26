package spring.boot.task1.boottask1.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class Product {
    @Id
    private String id;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;

    public Product withId(String id) {
        this.id = id;
        return this;
    }

    public Product withReviews(Set<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Product addReview(Review review) {
        Set<Review> reviews = this.reviews;
        reviews.add(review);
        this.reviews = reviews;
        return this;
    }
}