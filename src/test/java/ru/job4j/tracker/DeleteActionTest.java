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
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item for deleting"));
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any())).thenReturn(1);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно." + ln));
    }

    @Test
    @DisplayName("Test execute when item is not found")
    public void executeWhenItemIsNotFound() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item for deleting"));
        DeleteAction delete = new DeleteAction(out);
        Input input = mock(Input.class);
        delete.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки." + ln));
    }
}