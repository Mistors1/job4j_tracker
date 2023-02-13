package ru.job4j.tracker;

public class EditAction implements UserAction {

    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return  "=== Edit ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit application ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.replace(id, item);
        if (tracker.replace(id, item)) {
            out.println("Application changed successfully.");
        } else {
            out.println("Application not found. ");
        }

        return true;
    }
}
