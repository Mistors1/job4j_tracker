package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements  UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by name ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find applications by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> item = tracker.findByName(name);
        if (!item.isEmpty()) {
            for (Item names : item) {
              out.println(names);
            }
        } else {
            out.println("Applications with name: " + name + " not found.");
        }

        return true;
    }
}
