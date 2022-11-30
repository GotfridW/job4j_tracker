package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection conn;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection conn) {
        this.conn = conn;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            conn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    @Override
    public Item add(Item item) {
        Timestamp time = Timestamp.valueOf(item.getCreated());
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into items (name, created) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        )) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, time);
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        Timestamp time = Timestamp.valueOf(item.getCreated());
        try (PreparedStatement ps = conn.prepareStatement(
                "update items set name = ?, created = ? where id = ?")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, time);
            ps.setInt(3, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement ps = conn.prepareStatement(
                "delete from items where id = ?")) {
            ps.setInt(1, id);
            result = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(
                "select * from items")) {
            try (ResultSet set = ps.executeQuery()) {
                while (set.next()) {
                    result.add(getItem(set));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("select * from items where name = ?")) {
            ps.setString(1, key);
            try (ResultSet set = ps.executeQuery()) {
                while (set.next()) {
                    result.add(getItem(set));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return List.copyOf(result);
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement ps = conn.prepareStatement("select * from items where id = ?")) {
            ps.setInt(1, id);
            try (ResultSet set = ps.executeQuery()) {
                if (set.next()) {
                    item = getItem(set);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item getItem(ResultSet set) throws SQLException {
        Item item = new Item();
        item.setId(set.getInt("id"));
        item.setName(set.getString("name"));
        item.setCreated(set.getTimestamp("created").toLocalDateTime());
        return item;
    }
}