package ru.job4j.tracker;

public class Delete implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item deletion error.");
        }
        return true;
    }
}
