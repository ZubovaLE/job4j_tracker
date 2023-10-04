package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByIdActionTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    @DisplayName("Test execute when successful")
    public void executeSuccessfully() {
        //Given
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any())).thenReturn(1);

        //When
        findByIdAction.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Find item by id ===" + ln + "id: 1, name: Item, created: " +
                FORMATTER.format(item.getCreated()) + ln;
        assertThat(out.toString(), is(expected));
        assertThat(tracker.findAll().get(0).getName(), is("Item"));
    }

    @Test
    @DisplayName("Test execute when item is not found")
    void executeWhenNotFound() {
        //Given
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);

        //When
        findByIdAction.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Find item by id ===" + ln + "Заявка с введённым id не найдена" + ln;
        assertThat(out.toString(), is(expected));
    }
}