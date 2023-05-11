package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Add new ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new application ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Added application " + item);

        return true;
    }
}
