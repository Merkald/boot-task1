package spring.boot.task1.boottask1.service;

import spring.boot.task1.boottask1.model.Product;
import java.util.Optional;

public interface ProductService {
    void create(Product product);

    Optional<Product> getByField(Product product);
}
