package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.job4j.collection.UniqueText.isEquals;

class UniqueTextTest {

    @ParameterizedTest
    @CsvSource(value = {"My cat eats a mouse and milk, My cat eats milk and a mouse, true",
            "My cat eats a mouse and milk, A mouse is eaten by a cat, false"})
    @DisplayName("Test isEquals")
    void isEqualOrNot(String origin, String text, boolean result) {
        assertThat(isEquals(origin, text), is(result));
    }
}