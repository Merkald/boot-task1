package spring.boot.task1.boottask1.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
public class Product {
    @Id
    private String id;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;
}
