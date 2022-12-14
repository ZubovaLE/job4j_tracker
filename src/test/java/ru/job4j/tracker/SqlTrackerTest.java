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
    private static SqlTracker tracker;

    private Item itemOne;
    private Item itemTwo;
    private Item itemThree;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = ClassLoader.getSystemResourceAsStream("test.properties")) {
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
        tracker = new SqlTracker(connection);
    }

    @BeforeEach
    public void fillTable() {
        itemOne = new Item("item one");
        itemTwo = new Item("ITEM");
        itemThree = new Item("item");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items")) {
            statement.execute();
        }
    }

    @Test
    @DisplayName("FindById when add item then must get the same item")
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        assertThat(tracker.findById(itemOne.getId()), is(itemOne));
    }

    @Test
    @DisplayName("FindByName when add items")
    public void whenSaveItemsAndFindByName() {
        List<Item> items = tracker.findByName("item");
        assertThat(items.size(), is(2));
        assertFalse(items.contains(itemOne));
        assertTrue(items.contains(itemTwo));
        assertTrue(items.contains(itemThree));
    }

    @Test
    @DisplayName("FindAll when add items then get all items")
    public void whenSaveItemsAndFindAll() {
        List<Item> items = tracker.findAll();
        assertThat(items.size(), is(3));
        assertTrue(items.contains(itemOne));
        assertTrue(items.contains(itemTwo));
        assertTrue(items.contains(itemThree));
    }

    @Test
    @DisplayName("FindById when add and delete item then must be null")
    public void whenSaveAndDeleteItemAndFindByGeneratedIdThenMustBeNull() {
        assertThat(tracker.findById(itemTwo.getId()), is(itemTwo));
        assertTrue(tracker.delete(itemTwo.getId()));
        assertNull(tracker.findById(itemTwo.getId()));
    }

    @Test
    @DisplayName("Delete when wrong id then false")
    public void deleteWhenWrongIdThenFalse() {
        assertFalse(tracker.delete(1));
    }

    @Test
    @DisplayName("FindById when add and replace item then must be new item")
    public void whenSaveAndReplaceItemAndFindByGeneratedIdThenMustBeNull() {
        Item newItemTwo = new Item("new item 2");
        assertThat(tracker.findById(itemTwo.getId()), is(itemTwo));
        assertTrue(tracker.replace(itemTwo.getId(), newItemTwo));
        assertThat(tracker.findById(itemTwo.getId()), is(newItemTwo));
    }

    @Test
    @DisplayName("Replace when wrong id then false")
    public void replaceWhenWrongIdThenFalse() {
        assertFalse(tracker.replace(1, new Item("item")));
    }
}
