package ru.job4j.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextReportTest {

    @Test
    @DisplayName("Test generate method")
    void generate() {
        String inputName = "The first";
        String inputBody = "is a message";
        TextReport test = new TextReport();
        String out = test.generate(inputName, inputBody);
        String expected = "The first" + System.lineSeparator() + "is a message";
        assertEquals(expected, out);
    }
}