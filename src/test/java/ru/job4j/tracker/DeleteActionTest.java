package ru.job4j.tracker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeleteActionTest {

    @Test
    @DisplayName("Test execute when successful")
    void deleteSuccessfully() {
        //Given
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item for deleting"));
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any())).thenReturn(1);

        //When
        delete.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Delete item ===" + ln + "Заявка удалена успешно." + ln;
        assertThat(out.toString(), is(expected));
    }

    @Test
    @DisplayName("Test execute when item is not found")
    public void executeWhenItemIsNotFound() {
        //Given
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item for deleting"));
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);

        //When
        delete.execute(input, tracker);

        //Then
        String ln = System.lineSeparator();
        String expected = "=== Delete item ===" + ln + "Ошибка удаления заявки." + ln;
        assertThat(out.toString(), is(expected));
    }
}