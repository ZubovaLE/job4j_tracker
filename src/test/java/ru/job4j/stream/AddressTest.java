package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AddressTest {

    @Test
    @DisplayName("Test getCity")
    void getCity() {
        Address address = new Address("City", "Street", 1, 1);
        String out = address.getCity();
        String expected = "City";
        assertThat(expected, is(out));
    }

    @Test
    @DisplayName("Test equals when objects are equal")
    void testEqualsWhenEqual() {
        Address first = new Address("City", "Street", 1, 1);
        Address second = new Address("City", "Street", 1, 1);
        assertThat(first.equals(second), is(true));
    }

    @Test
    @DisplayName("Test equals when objects are not equal")
    void testEqualsWhenAreNotEqual() {
        Address first = new Address("City", "Street", 1, 1);
        Address second = new Address("City", "Street", 1, 2);
        assertThat(first.equals(second), is(false));
    }
}