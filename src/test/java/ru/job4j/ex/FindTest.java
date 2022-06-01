package ru.job4j.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTest {

    @Test
    @DisplayName("Test get method when proper index = 0")
    void testGetWhenProperIndexIs0() {
        String[] in = {"one", "two", "three", "four", "five"};
        int index = 0;
        String out = Find.get(in, index);
        String expected = "one";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test get method when proper index = 3")
    void testGetWhenProperIndexIs3() {
        String[] in = {"one", "two", "three", "four", "five"};
        int index = 3;
        String out = Find.get(in, index);
        String expected = "four";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test get method when index equals array size then exception")
    void testGetWhenIndexEqualsArraySizeThenException() {
        String[] in = {"one", "two", "three", "four", "five"};
        int index = 5;
        assertThrows(IllegalArgumentException.class, () -> Find.get(in, index));
    }

    @Test
    @DisplayName("Test get method when index is greater than array size then exception")
    void testGetWhenIndexIsGreaterThanArraySizeThenException() {
        String[] in = {"one", "two", "three", "four", "five"};
        int index = 7;
        assertThrows(IllegalArgumentException.class, () -> Find.get(in, index));
    }

    @Test
    @DisplayName("Test get method when index = -3 then exception")
    void testGetWhenIndexIsNegativeThenException() {
        String[] in = {"one", "two", "three", "four", "five"};
        int index = -3;
        assertThrows(IllegalArgumentException.class, () -> Find.get(in, index));
    }
}