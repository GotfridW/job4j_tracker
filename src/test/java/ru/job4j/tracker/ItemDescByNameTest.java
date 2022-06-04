package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Bill"),
                new Item("John"),
                new Item("Tom"),
                new Item("William")
        );
        List<Item> expected = Arrays.asList(
                new Item("William"),
                new Item("Tom"),
                new Item("John"),
                new Item("Bill")
        );
        items.sort(new ItemDescByName());
        assertEquals(items, expected);
    }
}