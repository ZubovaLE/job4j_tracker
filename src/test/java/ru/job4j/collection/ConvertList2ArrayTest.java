package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ConvertList2ArrayTest {

    @Test
    @DisplayName("Test toArray when 7 elements in 3 columns")
    public void when7ElementsIn3ColumnsThen9() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    @DisplayName("Test toArray when 5 elements in 2 columns")
    public void when5ElementsIn2ColumnsThen6() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 0, 4, 5),
                2
        );
        int[][] expect = {
                {1, 2},
                {0, 4},
                {5, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    @DisplayName("Test toArray when 5 elements in 1 column")
    public void when5ElementsIn1ColumThen5() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                1
        );
        int[][] expect = {
                {1},
                {2},
                {3},
                {4},
                {5}
        };
        assertThat(result, is(expect));
    }

    @Test
    @DisplayName("Test toArray when 5 elements in 5 columns")
    public void when5ElementsIn5ColumnsThen5() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                5
        );
        int[][] expect = {
                {1, 2, 3, 4, 5}
        };
        assertThat(result, is(expect));
    }

    @Test
    @DisplayName("Test toArray when 6 elements in 5 columns")
    public void when5ElementsIn5ColumnsThen10() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(0, 0, 0, 1, 0, 1),
                5
        );
        int[][] expect = {
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0}
        };
        assertThat(result, is(expect));
    }
}