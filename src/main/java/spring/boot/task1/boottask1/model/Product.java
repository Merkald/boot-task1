package spring.boot.task1.boottask1.model;

import lombok.Data;
import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Accessors(chain = true)
@Entity
public class Product {
    @Id
    private String id;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;
}
