package spring.boot.task1.boottask1.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Product;
import spring.boot.task1.boottask1.repository.ProductRepository;
import spring.boot.task1.boottask1.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> getByField(Product product) {
        Example<Product> example = Example.of(product);
        return productRepository.findOne(example);
    }
}
