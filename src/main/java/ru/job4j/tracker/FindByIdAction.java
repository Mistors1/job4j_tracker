package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find application by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Application with id " + id + " not found.");
        }

        return true;
    }
}
