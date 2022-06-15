package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BallTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @ParameterizedTest
    @DisplayName("Test tryRun method when 1.true, 2.false")
    @CsvSource(value = {"true,Ball was eaten", "false, Ball escaped"})
    void tryRun(boolean condition, String expected) {
        System.setOut(new PrintStream(out));
        Ball ball = new Ball();
        ball.tryRun(condition);
        String result = out.toString().trim();
        System.setOut(standardOut);
        assertThat(result, is(expected));
    }
}