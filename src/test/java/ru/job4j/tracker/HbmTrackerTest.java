package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HbmTrackerTest {

    @Test
    void whenAdd() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item", "great");
        tracker.add(item);
        assertEquals(item, tracker.findAll().get(0));
    }

    @Test
    void whenReplace() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item", "great");
        Item newItem = new Item("item", "great");
        tracker.add(item);
        tracker.replace(item.getId(), newItem);
        assertEquals(newItem, tracker.findAll().get(0));
    }

    @Test
    void delete() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item", "great");
        tracker.add(item);
        assertEquals(1, tracker.findAll().size());
        tracker.delete(item.getId());
        assertEquals(0, tracker.findAll().size());
    }

    @Test
    void findAll() {
        HbmTracker tracker = new HbmTracker();
        Item itemOne = new Item("item", "great");
        Item itemTwo = new Item("item", "great");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        List<Item> items = tracker.findAll();
        assertEquals(2, items.size());
        assertEquals(List.of(itemOne, itemTwo), items);
    }

    @Test
    void findByName() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item", "great");
        tracker.add(item);
        assertEquals(item, tracker.findByName("item").get(0));
    }

    @Test
    void findById() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item", "great");
        tracker.add(item);
        assertEquals(item, tracker.findById(item.getId()));
    }
}