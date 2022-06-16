package ru.job4j.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class UserTest {

    @Test
    @DisplayName("Test getPassport")
    void getPassport() {
        User user = new User("n001", "Ivan Petrov");
        String out = user.getPassport();
        String expected = "n001";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setPassport")
    void setPassport() {
        User user = new User("n001", "Ivan Petrov");
        user.setPassport("N002");
        String out = user.getPassport();
        String expected = "N002";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test getUsername")
    void getUsername() {
        User user = new User("n001", "Ivan Petrov");
        String out = user.getUsername();
        String expected = "Ivan Petrov";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setUsername")
    void setUsername() {
        User user = new User("n001", "Ivan Petrov");
        user.setUsername("Petr Ivanov");
        String out = user.getUsername();
        String expected = "Petr Ivanov";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test equals when objects are equal then true")
    void testEqualsWhenObjectsAreEqual() {
        User first = new User("n001", "Ivan Petrov");
        User second = new User("n001", "Petrov");
        assertThat(first.equals(second), is(true));
    }

    @Test
    @DisplayName("Test equals when objects are not equal then false")
    void testEqualsWhenObjectsAreNotEqual() {
        User first = new User("n001", "Ivan Petrov");
        User second = new User("n002", "Ivan Petrov");
        assertThat(first.equals(second), is(false));
    }
}