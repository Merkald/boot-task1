package spring.boot.task1.boottask1.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.service.PickingService;
import spring.boot.task1.boottask1.service.ProductService;
import spring.boot.task1.boottask1.service.ReviewService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private PickingService pickingService;

    @Override
    public List<String> mostCommentedFoodItems(int amount) {
        List<String> products = reviewService.getAllByField(new Review())
                .stream()
                .map(Review::getProductId)
                .distinct()
                .collect(Collectors.toList());
        List<Integer> activity = products
                .stream()
                .map(str -> reviewService.getAllByField(new Review().setProductId(str)).size())
                .collect(Collectors.toList());
        return pickingService.findTopQuantity(amount, products, activity);
    }
}
