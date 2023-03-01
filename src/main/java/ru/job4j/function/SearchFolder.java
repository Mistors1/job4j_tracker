package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> list1 = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                list1.add(f);
            }
        }
        return list1;
    }
}