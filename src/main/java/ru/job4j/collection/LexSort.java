package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] arr1 = left.split("\\.");
        String[] arr2 = right.split("\\.");

        String numL = arr1[0];
        String numR = arr2[0];

       int lNum = Integer.parseInt(numL);
       int rNum =  Integer.parseInt(numR);

        return Integer.compare(lNum, rNum);
    }
}