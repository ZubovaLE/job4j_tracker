package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    @DisplayName("Test compare when simple sort")
    void compare() {
        Item first = new Item(1, "B");
        Item second = new Item(2, "A");
        Item third = new Item(3, "C");
        List<Item> items = Arrays.asList(
                second,
                third,
                first
        );
        List<Item> expected = Arrays.asList(first, second, third);
        Collections.sort(items);
        assertEquals(expected, items);
    }

    @Test
    @DisplayName("Test when ascending sort order")
    void compareWhenAsc() {
        Item first = new Item(1, "Coffee");
        Item second = new Item(2, "Chocolate");
        Item third = new Item(3, "Tea");
        List<Item> items = Arrays.asList(
                second,
                third,
                first
        );
        List<Item> expected = Arrays.asList(second, first, third);
        items.sort(new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    @DisplayName("Test when descending sort order")
    void compareWhen() {
        Item first = new Item(1, "Coffee");
        Item second = new Item(2, "Chocolate");
        Item third = new Item(3, "Tea");
        List<Item> items = Arrays.asList(
                second,
                third,
                first
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(third, first, second);
        assertEquals(expected, items);
    }
}