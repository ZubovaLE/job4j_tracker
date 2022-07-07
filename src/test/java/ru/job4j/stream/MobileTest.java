package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MobileTest {

    @Test
    @DisplayName("Test getType when type is APPLE")
    void getType() {
        Mobile in = new Mobile(Mobile.Type.APPLE, 39000);

        Mobile.Type out = in.getType();

        Mobile.Type expected = Mobile.Type.APPLE;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test getPrise when prise = 40000")
    void getPrise() {
        Mobile in = new Mobile(Mobile.Type.SAMSUNG, 40000);

        int out = in.getPrice();

        int expected = 40000;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setPrise when new prise = 36000")
    void setPrise() {
        Mobile in = new Mobile(Mobile.Type.APPLE, 39000);
        int newPrice = 36000;

        in.setPrice(newPrice);

        assertThat(in.getPrice(), is(newPrice));
    }

    @Test
    @DisplayName("Test toString")
    void testToString() {
        Mobile in = new Mobile(Mobile.Type.APPLE, 39000);
        String expected = "Mobile{type=APPLE, price=39000}";
        assertThat(in.toString(), is(expected));
    }
}