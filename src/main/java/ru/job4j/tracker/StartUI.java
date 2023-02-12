package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new application ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Added application " + item);
            } else if (select == 1) {
                System.out.println("=== Show all applications ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("No applications.");
                }
            } else if (select == 2) {
                System.out.println("=== Edit application ===");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.replace(id, item);
                if (tracker.replace(id, item)) {
                    System.out.println("Application changed successfully.");
                } else {
                    System.out.println("Application not found. ");
                }
            } else if (select == 3) {
                System.out.println("=== Delete application ===");
                int id = input.askInt("Enter id: ");
                if (tracker.delete(id)) {
                    System.out.println("Application deleted successfully.");
                } else {
                    System.out.println("Application not found.");
                }
            } else if (select == 4) {
                System.out.println("=== Find application by id ===");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Application with id " + id + " not found.");
                }
            } else if (select == 5) {
                System.out.println("=== Find applications by name ===");
                String name = input.askStr("Enter name: ");
                Item[] item = tracker.findByName(name);
                if (item.length > 0) {
                    for (Item names : item) {
                        System.out.println(names);
                    }
                } else {
                    System.out.println("Applications with name: " + name + " not found.");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new application", "Show all applications", "Edit application",
                "Delete application", "Find application by id", "Find applications by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
