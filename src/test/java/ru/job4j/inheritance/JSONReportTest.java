package ru.job4j.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JSONReportTest {
    String ln = System.lineSeparator();

    @Test
    @DisplayName("Test generate method")
    public void whenTestGenerateMethod() {
        String expected = "{" + ln
                + "\t\"name\" : \"Report's name\"," + ln
                + "\t\"body\" : \"Report's body\"" + ln
                + "}";
        String name = "Report's name";
        String body = "Report's body";
        String result = new JSONReport().generate(name, body);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test generate method when name is David, body is name of his song ")
    public void whenNameIsDavidBodyIsNameSong() {
        String expected = "{" + ln
                + "\t\"name\" : \"David Gilmour\"," + ln
                + "\t\"body\" : \"Shine On You Crazy Diamond\"" + ln
                + "}";
        String name = "David Gilmour";
        String body = "Shine On You Crazy Diamond";
        String result = new JSONReport().generate(name, body);
        assertEquals(expected, result);
    }
}