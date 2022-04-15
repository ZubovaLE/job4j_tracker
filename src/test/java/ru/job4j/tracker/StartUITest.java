package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartUITest {

    @Test
    @DisplayName("Test init method when add new item")
    void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertEquals(tracker.findAll()[0].getName(), "Item name");
    }

    @Test
    @DisplayName("Test init method when edit an item")
    void whenEditItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Edited item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertEquals(tracker.findById(item.getId()).getName(), replacedName);
    }

    @Test
    @DisplayName("Test init method when delete an item")
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    @DisplayName("Test init method when delete an item")
    void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertEquals(out.toString(),
                "Menu:" + System.lineSeparator() +
                        "0. Exit Program" + System.lineSeparator() + "The program is finished. Thank you!" + System.lineSeparator()
        );
    }
}