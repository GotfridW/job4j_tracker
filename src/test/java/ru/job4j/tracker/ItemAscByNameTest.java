package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.model.ItemAscByName;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Beta"),
                new Item("Gamma"),
                new Item("Alpha"),
                new Item("Lambda")
        );
        List<Item> expected = Arrays.asList(
                new Item("Alpha"),
                new Item("Beta"),
                new Item("Gamma"),
                new Item("Lambda")
        );
        items.sort(new ItemAscByName());
        assertEquals(items, expected);
    }
}