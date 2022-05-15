package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StartUITest {
    private final String ln = System.lineSeparator();

    @Test
    @DisplayName("Test init method when add new item")
    void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(in, tracker, actions);
        assertEquals(tracker.findAll().get(0).getName(), "Item name");
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
        List<UserAction> actions = Arrays.asList(
                new EditAction(output),
                new ExitAction(output)
        );
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
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    @DisplayName("Test init method when exit program")
    void whenExit() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Exit Program")
                .append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test when EditAction then output is successful")
    void whenEditActionTestOutputIsSuccessful() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New test name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Edit Item").append(ln).append("1. Exit Program").append(ln)
                .append("=== Edit item ===").append(ln).append("Заявка изменена успешно.").append(ln)
                .append("Menu:").append(ln).append("0. Edit Item").append(ln).append("1. Exit Program")
                .append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test when ShowAction then output is successful")
    void whenShowActionTestOutputIsSuccessful() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("first"));
        Item two = tracker.add(new Item("second"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ShowAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Show all Items").append(ln)
                .append("1. Exit Program").append(ln).append("=== Show all items ===")
                .append(ln).append(one.toString()).append(ln).append(two.toString())
                .append(ln).append("Menu:").append(ln).append("0. Show all Items").append(ln)
                .append("1. Exit Program").append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test ShowAction when the tracker is empty yet")
    void testShowActionWhenTrackerIsEmpty() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ShowAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Show all Items").append(ln)
                .append("1. Exit Program").append(ln).append("=== Show all items ===")
                .append(ln).append("Хранилище еще не содержит заявок")
                .append(ln).append("Menu:").append(ln).append("0. Show all Items").append(ln)
                .append("1. Exit Program").append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test when FindById then output is successful")
    void whenFindByIdActionTestOutputIsSuccessful() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("first"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Find Item by id").append(ln)
                .append("1. Exit Program").append(ln).append("=== Find item by id ===")
                .append(ln).append(one).append(ln).append("Menu:")
                .append(ln).append("0. Find Item by id").append(ln)
                .append("1. Exit Program").append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test FindById when the item is not found")
    void testFindByIdActionWhenItemIsNotFound() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "5", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Find Item by id").append(ln)
                .append("1. Exit Program").append(ln).append("=== Find item by id ===")
                .append(ln).append("Заявка с введённым id не найдена").append(ln).append("Menu:")
                .append(ln).append("0. Find Item by id").append(ln)
                .append("1. Exit Program").append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test when FindByName then output is successful")
    void whenFindByNameActionTestOutputIsSuccessful() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("first"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getName()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Find Item by name").append(ln)
                .append("1. Exit Program").append(ln).append("=== Find item by name ===")
                .append(ln).append(one).append(ln).append("Menu:")
                .append(ln).append("0. Find Item by name").append(ln)
                .append("1. Exit Program").append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test FindByName when an item is not found")
    void testFindByNameActionWhenItemIsNotFound() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "any", "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Find Item by name").append(ln)
                .append("1. Exit Program").append(ln).append("=== Find item by name ===")
                .append(ln).append("Заявки с именем: any не найдены.").append(ln).append("Menu:")
                .append(ln).append("0. Find Item by name").append(ln)
                .append("1. Exit Program").append(ln).append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }

    @Test
    @DisplayName("Test when enter non-existence menu option and then enter correct option")
    void whenInvalidExit() {
        StringBuilder expected = new StringBuilder();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        expected.append("Menu:").append(ln).append("0. Exit Program").append(ln).append("Wrong input, you can select: 0 .. 0")
                .append(ln).append("Menu:").append(ln).append("0. Exit Program").append(ln)
                .append("The program is finished. Thank you!").append(ln);
        assertEquals(expected.toString(), out.toString());
    }
}