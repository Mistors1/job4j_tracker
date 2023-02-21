package ru.job4j.collection;

import java.util.List;
import java.util.HashSet;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task number : list) {
                numbers.add(number.getNumber());
        }
        return numbers;
    }
}
