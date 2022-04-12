package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartUITest {

    @Test
    @DisplayName("Test creatItem method")
    void whenAddItem() {
        String[] answers = {"Fix PC"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertEquals(created.getName(), expected.getName());
    }

    @Test
    @DisplayName("Test editItem method")
    void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
                "edited item"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertEquals(edited.getName(), "edited item");
    }

    @Test
    @DisplayName("Test deleteItem method")
    void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    void init() {
    }
}