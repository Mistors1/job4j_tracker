package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (left.length() != right.length()) {
            rsl = 1;
        } else {
            for (int i = 0; i < left.length(); i++) {
                char let1 = left.charAt(i);
                char let2 = right.charAt(i);
                if (Character.compare(let1, let2) != 0) {
                    rsl = Character.compare(let1, let2);
                    break;
                }
                rsl = Character.compare(let1, let2);
            }
        }

        return rsl;
    }
}