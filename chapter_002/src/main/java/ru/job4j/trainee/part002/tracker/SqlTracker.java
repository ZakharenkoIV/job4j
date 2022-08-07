package ru.job4j.trainee.part002.tracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SqlTracker implements Store {
    private final Connection con;

    public SqlTracker(Connection connection) {
        this.con = connection;
    }

    @Override
    public void close() throws Exception {
        if (con != null) {
            con.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = con.prepareStatement(
                "Insert into items(name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                item.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int processedLines = 0;
        try (PreparedStatement ps = con.prepareStatement("update items set name = (?) where id = (?)")) {
            ps.setString(1, item.getName());
            ps.setInt(2, id);
            processedLines = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processedLines != 0;
    }

    @Override
    public boolean delete(int id) {
        int processedLines = 0;
        try (PreparedStatement ps = con.prepareStatement("delete from items where id = (?)")) {
            ps.setInt(1, id);
            processedLines = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processedLines != 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("select * FROM items")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getInt("id"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void findAllByReact(Consumer<Item> consumer) {
        try (PreparedStatement ps = con.prepareStatement("select * FROM items")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getInt("id"));
                consumer.accept(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement("select * FROM items where name = (?)")) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getInt("id"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item("");
        try (PreparedStatement ps = con.prepareStatement("select * FROM items where id = (?)")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                item = new Item(rs.getString("name"));
                item.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}