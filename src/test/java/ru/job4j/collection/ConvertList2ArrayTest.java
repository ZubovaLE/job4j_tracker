package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ConvertList2ArrayTest {

    @Test
    @DisplayName("Test toArray when 7 elements in 3 rows")
    public void when7ElementsIn3RowsThen9() {
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
    @DisplayName("Test toArray when 5 elements in 2 rows")
    public void when5ElementsIn2RowsThen6() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                2
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    @DisplayName("Test toArray when 5 elements in 1 row")
    public void when5ElementsIn1RowThen5() {
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
    @DisplayName("Test toArray when 5 elements in 1 row")
    public void when5ElementsIn5RowsThen5() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5),
                5
        );
        int[][] expect = {
                {1, 2, 3, 4, 5}
        };
        assertThat(result, is(expect));
    }
}