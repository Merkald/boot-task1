package spring.boot.task1.boottask1.service;

import java.util.List;

public interface LogicService {
    List<String> getMostPopularWords(int amount, List<String> words, List<Integer> activity);
}
