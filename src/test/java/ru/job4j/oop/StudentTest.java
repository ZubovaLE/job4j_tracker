package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StudentTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outStreamCaptor = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();
    private final Student student = new Student();

    @Test
    @DisplayName("Test music method")
    void music() {
        System.setOut(new PrintStream(outStreamCaptor));
        student.music();
        String result = outStreamCaptor.toString().trim();
        String expected = "Tra-la-la";
        assertThat(result, is(expected));
    }

    @Test
    @DisplayName("Test song method")
    void song() {
        System.setOut(new PrintStream(outStreamCaptor));
        student.song();
        String result = outStreamCaptor.toString().trim();
        String expected = "I believe I can fly";
        System.setOut(standardOut);
        assertThat(result, is(expected));
    }

    @Test
    @DisplayName("Test main method")
    void main() {
        System.setOut(new PrintStream(outStreamCaptor));
        StringBuilder expected = new StringBuilder();
        expected.append("Tra-la-la").append(ln).append("I believe I can fly")
                .append(ln).append("Tra-la-la").append(ln)
                .append("I believe I can fly").append(ln)
                .append("Tra-la-la").append(ln).
                append("I believe I can fly");
        Student.main(null);
        String result = outStreamCaptor.toString().trim();
        System.setOut(standardOut);
        assertThat(result, is(expected));
    }
}