package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    @DisplayName("Test execute when successful")
    void executeSuccessfully() {
        //Given
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String itemName = "Item";
        Item item = new Item(itemName);
        tracker.add(item);
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any())).thenReturn(itemName);

        //When
        find.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Find item by name ===" + ln + "id: " + item.getId() + ", name: " + itemName +
                ", created: " + FORMATTER.format(item.getCreated()) + ln;

        assertThat(out.toString(), is(expected));
    }

    @Test
    @DisplayName("Test execute when item is not found")
    void executeWhenItemIsNotFound() {
        //Given
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        Input input = mock(Input.class);
        String anotherItemName = "name";
        when(input.askStr(any())).thenReturn(anotherItemName);
        FindByNameAction find = new FindByNameAction(out);

        //When
        find.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Find item by name ===" + ln + "Заявки с именем: " + anotherItemName + " не найдены." + ln;
        assertThat(out.toString(), is(expected));
    }
}