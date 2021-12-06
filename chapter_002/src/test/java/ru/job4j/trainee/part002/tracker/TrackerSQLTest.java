package ru.job4j.trainee.part002.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {

    static Connection connection;

    @BeforeClass
    public static void init() {
        try (InputStream in = TrackerSQLTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

//    @After
//    public void wipeTable() throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
//            statement.execute();
//        }
//    }

    @Test
    public void addItem() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void replaceItem() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            Item item = tracker.add(new Item("name"));
            tracker.replace(item.getId(), new Item("test"));
            assertThat(tracker.findByName("test").size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteItem() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            Item item = tracker.add(new Item("name"));
            tracker.delete(item.getId());
            assertThat(tracker.findByName("name").size(), is(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllItems() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            List<Item> expected = tracker.findAll();
            Item item1 = tracker.add(new Item("name"));
            Item item2 = tracker.add(new Item("test"));
            expected.add(item1);
            expected.add(item2);
            List<Item> actual = tracker.findAll();
            Collections.sort(expected);
            Collections.sort(actual);
            assertThat(actual, is(expected));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByNameItem() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            tracker.add(new Item("name"));
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByIdItem() {
        try (SqlTracker tracker = new SqlTracker(connection)) {
            Item item = tracker.add(new Item("name"));
            assertThat(tracker.findById(item.getId()).getName(), is("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
