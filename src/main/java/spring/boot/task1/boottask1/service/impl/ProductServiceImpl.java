package spring.boot.task1.boottask1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Review;
import spring.boot.task1.boottask1.service.ProductService;
import spring.boot.task1.boottask1.service.ReviewService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ReviewService reviewService;

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
        List<String> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int max = activity
                    .stream()
                    .max(Integer::compareTo)
                    .orElseThrow();
            int indexOfMax = activity.indexOf(max);
            result.add(products.get(indexOfMax));
            products.remove(indexOfMax);
            activity.remove(indexOfMax);
        }
        return result;
    }
}
