package ru.job4j.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindElTest {

    @Test
    @DisplayName("Test indexOf method when the element is not found then ElementNotFoundException")
    void indexOfWhenElementIsNotFoundThenElementNotFoundException() {
        String[] input = {"one", "two", "three"};
        String key = "four";
        assertThrows(ElementNotFoundException.class, () -> FindEl.indexOf(input, key));
    }

    @Test
    @DisplayName("Test indexOf method when the element is found")
    void indexOfWhenElementIsFound() throws ElementNotFoundException {
        String[] input = {"one", "two", "three"};
        String key = "two";
        int expected = 1;
        int out = FindEl.indexOf(input, key);
        assertEquals(expected, out);
    }
}