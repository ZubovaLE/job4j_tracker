package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StringCompareTest {

    @Test
    @DisplayName("Test when strings are equal, then result = 0")
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Ivanov, Petrov",
            "Ivanov, Ivanova",
            "Patrova, Petrov"
    })
    @DisplayName("Test when result is negative")
    void testWhenResultIsNegative(String left, String right) {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                left,
                right
        );
        assertThat(rst, lessThan(0));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Petrov, Ivanova",
            "Petrov, Patrov",
            "Petrova, Petrov"
    })
    @DisplayName("Test when result is positive")
    void testWhenResultIsPositive(String left, String right) {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                left,
                right
        );
        assertThat(rst, greaterThan(0));
    }
}