package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(new ArrayList<>(
                List.of("0", "Item name", "1")));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(
                List.of(new Create(output), new Exit()));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void  whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new ArrayList<>(
                List.of("0", String.valueOf(item.getId()), replacedName, "1")));
        List<UserAction> actions = new ArrayList<>(List.of(
                new Edit(output),
                new Exit()
        ));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new ArrayList<>(List.of("0", String.valueOf(item.getId()), "1"))
        );
        List<UserAction> actions = new ArrayList<>(List.of(
                new Delete(output),
                new Exit()
        ));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new ArrayList<>(List.of("0", "1")
        ));
        List<UserAction> actions =
                new ArrayList<>(List.of(
                        new ShowAll(out),
                        new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                              + "0. Show all items" + ln
                              + "1. Exit program" + ln
                              + "=== Show all items ===" + ln
                              + item + ln + "Menu:" + ln
                              + "0. Show all items" + ln
                              + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test10"));
        Input in = new StubInput(
                new ArrayList<>(List.of(
                   "0", String.valueOf(item.getId()), "1")
        ));
        List<UserAction> actions = new ArrayList<>(
                List.of(
                new FindById(out),
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit program" + ln
                + "=== Find by id ===" + ln
                + item + ln + "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test100"));
        Input in = new StubInput(
                new ArrayList<>(List.of("0", item.getName(), "1")
        ));
        List<UserAction> actions = new ArrayList<>(List.of(
                new FindByName(out), new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Find item by name" + ln
                + "1. Exit program" + ln
                + "=== Find items by name ===" + ln
                + item + ln + "Menu:" + ln
                + "0. Find item by name" + ln
                + "1. Exit program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new ArrayList<>(asList("2", "0")
        ));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>(List.of(
                new Exit()
        ));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Exit program" + ln
                + "Wrong input, you can select options 0 .. 0" + ln
                + "Menu:" + ln
                + "0. Exit program" + ln
        ));
    }
}






