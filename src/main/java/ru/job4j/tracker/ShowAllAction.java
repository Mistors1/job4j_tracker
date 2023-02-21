package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all ===";
    }

    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all applications ===");
        List<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
              out.println(item);
            }
        } else {
          out.println("No applications.");
        }

        return true;
    }
}
