package spring.boot.task1.boottask1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.task1.boottask1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
