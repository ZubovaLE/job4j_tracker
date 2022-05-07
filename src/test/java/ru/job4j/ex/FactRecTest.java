package ru.job4j.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactRecTest {

    @Test
    @DisplayName("Test calc method when n < 0 then IllegalArgumentException")
    void calcWhenNIsLessThan0ThenException() {
        assertThrows(IllegalArgumentException.class, () -> FactRec.calc(-3));
    }

    @Test
    @DisplayName("Test calc method when n = 0 then result = 1")
    void calcWhenNIs0Then1() {
        int in = 0;
        int out = FactRec.calc(in);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test calc method when n = 1 then result = 1")
    void calcWhenNIs1Then1() {
        int in = 1;
        int out = FactRec.calc(in);
        int expected = 1;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test calc method when n = 1 then result = 1")
    void calcWhenNIs3Then6() {
        int in = 3;
        int out = FactRec.calc(in);
        int expected = 6;
        assertEquals(expected, out);
    }
}