package spring.boot.task1.boottask1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.task1.boottask1.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
