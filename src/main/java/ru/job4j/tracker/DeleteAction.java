package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete application ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Application deleted successfully.");
        } else {
            out.println("Application not found.");
        }

        return true;
    }
}
