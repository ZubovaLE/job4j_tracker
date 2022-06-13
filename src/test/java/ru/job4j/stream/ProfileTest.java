package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ProfileTest {

    @Test
    @DisplayName("Test getAddress")
    void getAddress() {
        Address address = new Address("City", "Street", 1, 1);
        Profile profile = new Profile(address);
        Address expected = profile.getAddress();
        assertThat(expected, is(address));

    }
}