package spring.boot.task1.boottask1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.service.LogicService;
import spring.boot.task1.boottask1.service.ProductService;
import spring.boot.task1.boottask1.service.ReviewService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private LogicService logicService;

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
       return logicService.getMostPopularWords(amount,products,activity);
    }
}
