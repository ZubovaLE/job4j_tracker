package ru.job4j.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FactorialTest {

    @Test
    @DisplayName("Test calc method when exception")
    void testCalcWhenException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calc(-5));
    }

    @ParameterizedTest
    @DisplayName("Test calc method when n = 0, n = 1, n = 5")
    @CsvSource(value = {"0, 1", "1, 1", " 5, 120"})
    void testCalcWhenNIs5(int in, int expected) {
        int out = Factorial.calc(in);
        assertThat(out, is(expected));
    }
}