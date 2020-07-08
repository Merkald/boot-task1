package spring.boot.task1.boottask1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.task1.boottask1.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
