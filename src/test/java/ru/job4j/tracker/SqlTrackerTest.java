package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Properties;

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
    public void whenSaveItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        List<Item> items = tracker.findByName("item");
        long time = items.get(0).getCreated().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        long time2 = item.getCreated().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        assertThat(items.get(0).getName(), is(item.getName()));
        assertThat(time, is(time2));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item 1");
        tracker.add(item);
        List<Item> items = tracker.findByName("item 1");
        long time = items.get(0).getCreated().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        long time2 = item.getCreated().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        assertThat(items.get(0).getName(), is(item.getName()));
        assertThat(time, is(time2));
        tracker.delete(items.get(0).getId());
        List<Item> items2 = tracker.findByName("item 1");
        assertThat(items2.size(), is(0));
    }
}