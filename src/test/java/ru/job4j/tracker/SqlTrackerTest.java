package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveAndReplaceItemThenItemsIdentical() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Peter");
        Item swap = new Item("John");
        tracker.add(item);
        int id = item.getId();
        tracker.replace(id, swap);
        item.setName(swap.getName());
        item.setCreated(swap.getCreated());
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveAndDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.delete(item.getId())).isTrue();
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenSaveItemsAndFindAllThenItemsIdentical() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("Alpha");
        Item itemB = new Item("Beta");
        tracker.add(itemA);
        tracker.add(itemB);
        assertThat(tracker.findAll()).isEqualTo(List.of(itemA, itemB));
    }

    @Test
    public void whenFindByNameGivesMultipleItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("Tom");
        Item itemB = new Item("Mary");
        Item itemC = new Item("Alex");
        Item itemD = new Item("Mary");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        tracker.add(itemD);
        assertThat(tracker.findByName("Mary")).isEqualTo(List.of(itemB, itemD));
    }

    @Test
    public void whenFindingById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemA = new Item("First");
        Item itemB = new Item("Second");
        Item itemC = new Item("Third");
        tracker.add(itemA);
        tracker.add(itemB);
        tracker.add(itemC);
        assertThat(tracker.findById(itemB.getId())).isEqualTo(itemB);
    }
}