package ru.job4j.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class RefMethodTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @ParameterizedTest
    @DisplayName("Test cutOut when " +
            "1. length is more than 10; " +
            "2. length is less than 10")
    @CsvSource(value = {"Yevgeniy Petrov, Yevgeniy P..", "Ivan, Ivan"})
    void cutOut(String in, String expected) {
        System.setOut(new PrintStream(outputStreamCaptor));
        RefMethod.cutOut(in);
        String result = outputStreamCaptor.toString().trim();
        System.setOut(standardOut);
        assertThat(result, is(expected));
    }
}