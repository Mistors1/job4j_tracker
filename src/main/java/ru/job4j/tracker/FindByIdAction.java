package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find by id ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) throws RuntimeException {
        out.println("=== Find application by id ===");
        int id = input.askInt("Enter id: ");
        Item item;
        try {
            item = tracker.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.println(Objects.requireNonNullElseGet(item, () -> "Application with id " + id + " not found."));

        return true;
    }
}
