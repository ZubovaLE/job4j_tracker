package ru.job4j.tracker;

import org.junit.jupiter.api.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
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
    @DisplayName("FindById when add item then must get the same item")
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    @DisplayName("FindByName when add items")
    public void whenSaveItemsAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item one");
        Item itemTwo = new Item("two");
        Item itemThree = new Item("item three");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> items = tracker.findByName("item");
        assertThat(items.size(), is(2));
        assertTrue(items.contains(itemOne));
        assertFalse(items.contains(itemTwo));
        assertTrue(items.contains(itemThree));
    }

    @Test
    @DisplayName("FindAll when add items then get all items")
    public void whenSaveItemsAndFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item one");
        Item itemTwo = new Item("item two");
        Item itemThree = new Item("item three");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> items = tracker.findAll();
        assertThat(items.size(), is(3));
        assertTrue(items.contains(itemOne));
        assertTrue(items.contains(itemTwo));
        assertTrue(items.contains(itemThree));
    }

    @Test
    @DisplayName("FindById when add and delete item then must be null")
    public void whenSaveAndDeleteItemAndFindByGeneratedIdThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item 1");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
        assertTrue(tracker.delete(item.getId()));
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    @DisplayName("Delete when wrong id then false")
    public void deleteWhenWrongIdThenFalse() {
        SqlTracker tracker = new SqlTracker(connection);
        assertFalse(tracker.delete(1));
    }

    @Test
    @DisplayName("FindById when add and replace item then must be new item")
    public void whenSaveAndReplaceItemAndFindByGeneratedIdThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item newItem = new Item("new");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
        assertTrue(tracker.replace(item.getId(), newItem));
        assertThat(tracker.findById(item.getId()), is(newItem));
    }

    @Test
    @DisplayName("Replace when wrong id then false")
    public void replaceWhenWrongIdThenFalse() {
        SqlTracker tracker = new SqlTracker(connection);
        assertFalse(tracker.replace(1, new Item("item")));
    }
}
