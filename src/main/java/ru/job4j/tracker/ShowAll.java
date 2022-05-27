package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAll implements UserAction {
    private  final Output out;

    public  ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        ArrayList<Item> items = tracker.findAll();
        if (!items.isEmpty()) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("No items found in storage");
        }
        return true;
    }
}
