package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class ShowActionTest {

    @Test
    @DisplayName("Test execute when one item then return correct info")
    void executeWhenOneItemThenReturnCorrectInfo() {
        //Given
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("item");
        tracker.add(item);
        ShowAction show = new ShowAction(output);
        Input input = mock(Input.class);

        //When
        show.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Show all items ===" + ln + item + ln;
        assertThat(expected, is(output.toString()));
    }

    @Test
    @DisplayName("Test execute when no items")
    void executeWhenNoItemsThenReturnCorrectInfo() {
        //Given
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        ShowAction show = new ShowAction(output);
        Input input = mock(Input.class);

        //When
        show.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Show all items ===" + ln + "Хранилище еще не содержит заявок" + ln;
        assertThat(expected, is(output.toString()));
    }
}