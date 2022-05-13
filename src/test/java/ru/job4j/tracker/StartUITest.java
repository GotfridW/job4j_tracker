package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output), new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void  whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new Edit(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new Delete(output),
                new Exit()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenShowAllItemsTestOutputIsSuccessful() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAll(out), new Exit(),
        };
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
                new String[] {
                        "0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindById(out), new Exit()
        };
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
                new String[]{"0", item.getName(), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByName(out), new Exit()
        };
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
}






