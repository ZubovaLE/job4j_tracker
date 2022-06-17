package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class JukeboxTest {
    private final PrintStream standardOutput = System.out;
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();

    @Test
    @DisplayName("Test music when position = 1")
    void musicWhen1() {
        System.setOut(new PrintStream(outputCaptor));
        Jukebox test = new Jukebox();
        test.music(1);
        String expected = "Песня: Пусть бегут неуклюже";
        String result = outputCaptor.toString().trim();
        System.setOut(standardOutput);
        assertThat(result, is(expected));
    }

    @Test
    @DisplayName("Test music when position = 2")
    void musicWhen2() {
        System.setOut(new PrintStream(outputCaptor));
        Jukebox test = new Jukebox();
        test.music(2);
        String expected = "Песня: Спокойной ночи";
        String result = outputCaptor.toString().trim();
        System.setOut(standardOutput);
        assertThat(result, is(expected));
    }

    @Test
    @DisplayName("Test music when position = -5")
    void musicWhenAnother() {
        System.setOut(new PrintStream(outputCaptor));
        Jukebox test = new Jukebox();
        test.music(-5);
        String expected = "Песня не найдена";
        String result = outputCaptor.toString().trim();
        System.setOut(standardOutput);
        assertThat(result, is(expected));
    }
}