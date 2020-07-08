package spring.boot.task1.boottask1.service;

import java.util.Optional;
import spring.boot.task1.boottask1.model.Product;

public interface ProductService {
    void create(Product product);

    Optional<Product> getByField(Product product);
}
