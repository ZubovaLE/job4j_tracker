package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ErrorTest {
    private final PrintStream standardOutput = System.out;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();

    @Test
    @DisplayName("Test getInfo")
    void getInfo() {
        Error error = new Error(true, 8, "Internet connection error");
        System.setOut(new PrintStream(outputCaptor));
        error.getInfo();
        StringBuilder expected = new StringBuilder();
        expected.append("Error is active: true").append(ln)
                .append("Status: 8").append(ln)
                .append("Message: Internet connection error");
        String result = outputCaptor.toString().trim();
        System.setOut(standardOutput);
        assertThat(result, is(expected.toString()));
    }

    @Test
    @DisplayName("Test main")
    void main() {
        System.setOut(new PrintStream(outputCaptor));
        Error.main(null);
        StringBuilder expected = new StringBuilder();
        expected.append("Error is active: false").append(ln)
                .append("Status: 0").append(ln)
                .append("Message: null").append(ln)
                .append("Error is active: true").append(ln)
                .append("Status: 8").append(ln)
                .append("Message: Internet connection error").append(ln)
                .append("Error is active: true").append(ln)
                .append("Status: 5").append(ln)
                .append("Message: Access denied");
        String result = outputCaptor.toString().trim();
        System.setOut(standardOutput);
        assertThat(result, is(expected.toString()));
    }
}