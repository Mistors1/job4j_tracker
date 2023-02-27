package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.priority(), o2.priority());
    }
}
