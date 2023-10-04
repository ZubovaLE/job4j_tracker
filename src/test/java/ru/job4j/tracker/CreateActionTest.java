package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreateActionTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String itemName = "Item";
        CreateAction create = new CreateAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any())).thenReturn(itemName);
        LocalDateTime data = LocalDateTime.now().withNano(0);
        create.execute(input, tracker);

        String ln = System.lineSeparator();
        String expected = "=== Create a new Item ===" + ln + "Добавленная заявка: " + "id: 1" + ", name: " + itemName +
                ", created: " + FORMATTER.format(data) + ln;

        assertThat(out.toString(), is(expected));
    }
}