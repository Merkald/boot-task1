package spring.boot.task1.boottask1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.task1.boottask1.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
