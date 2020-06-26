package spring.boot.task1.boottask1.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String profileName;
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    public User withId(String id) {
        this.id = id;
        return this;
    }

    public User withProfileName(String profileName) {
        this.profileName = profileName;
        return this;
    }
}