package spring.boot.task1.boottask1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String login;
    String password;

    public User insertLogin(String login) {
        this.login = login;
        return this;
    }

    public User insertPassword(String password) {
        this.password = password;
        return this;
    }

}
