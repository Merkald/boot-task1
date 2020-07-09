package spring.boot.task1.boottask1.service;

import java.util.List;

public interface PickingService {
    List<String> findTopQuantity(int amount, List<String> words, List<Integer> activity);
}
