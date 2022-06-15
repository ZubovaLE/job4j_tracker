package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BallStoryTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();

    @Test
    @DisplayName("Test main when hare.tryEat(ball); and wolf.tryEat(ball); and fox.tryEat(ball);")
    void main() {
        System.setOut(new PrintStream(outputStreamCaptor));
        BallStory.main(null);
        StringBuilder expected = new StringBuilder();
        expected.append("Ball escaped").append(ln).append("Ball escaped").append(ln).append("Ball was eaten");
        String result = outputStreamCaptor.toString().trim();
        System.setOut(standardOut);
        assertThat(result, is(expected));
    }
}