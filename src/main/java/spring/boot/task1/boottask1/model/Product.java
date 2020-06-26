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
}