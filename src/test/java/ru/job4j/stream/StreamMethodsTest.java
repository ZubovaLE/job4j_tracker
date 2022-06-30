package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StreamMethodsTest {

    @Test
    @DisplayName("Test listAfterMapping")
    void listAfterMapping() {
        int[] in = new int[]{1, 2, 3, 4, 5};
        int[] out = StreamMethods.arrayAfterMapping(in);
        int[] expected = {3, 6, 9, 12, 15};
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test arrayAfterMapping")
    void arrayAfterMapping() {
        List<Integer> in = List.of(1, 2, 3);
        List<Integer> out = StreamMethods.listAfterMapping(in);
        List<Integer> expected = List.of(1, 4, 9);
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test arrayAfterFiltering")
    void arrayAfterFiltering() {
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] out = StreamMethods.arrayAfterFiltering(in);
        int[] expected = {2, 4, 6, 8, 10};
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test listAfterFiltering")
    void listAfterFiltering() {
        List<Integer> in = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> out = StreamMethods.listAfterFiltering(in);
        List<Integer> expected = List.of(3, 4, 5);
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test arrayAfterReducing")
    void arrayAfterReducing() {
        int[] in = new int[]{1, 2};
        int out = StreamMethods.arrayAfterReducing(in);
        int expected = 3;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test listAfterReducing")
    void listAfterReducing() {
        List<Integer> in = List.of(0, 1, 2);
        int out = StreamMethods.listAfterReducing(in);
        int expected = 6;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test arrayAfterFlatMapping")
    void arrayAfterFlatMapping() {
        int[] in = new int[]{1, 2, 3, 4, 5, 6};
        int[] out = StreamMethods.arrayAfterFlatMapping(in);
        int[] expected = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 1, 2};
        assertThat(out, is(expected));
    }
}