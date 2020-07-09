package spring.boot.task1.boottask1.service.impl;

import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.service.PickingService;
import java.util.ArrayList;
import java.util.List;

@Service
public class PickingServiceImpl implements PickingService {
    @Override
    public List<String> findTopQuantity(int amount, List<String> words, List<Integer> activity) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i<amount;i++) {
            int max = activity
                    .stream()
                    .max(Integer::compareTo)
                    .orElseThrow();
            int indexOfMax = activity.indexOf(max);
            result.add(words.get(indexOfMax));
            words.remove(indexOfMax);
            activity.remove(indexOfMax);
        }
        return result;
    }
}
