package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
       String rsl = null;
        for (int i = 0; i < count; i++) {
             rsl = String.valueOf(queue.poll().name());
        }

        return rsl;
    }

    public String getFirstUpsetCustomer() {
        String rsl = null;
        for (int i = 0; i <= count; i++) {
            rsl = String.valueOf(queue.poll().name());
        }

        return rsl;
    }
}
