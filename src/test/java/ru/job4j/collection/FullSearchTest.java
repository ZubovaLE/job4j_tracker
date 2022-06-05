package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FullSearchTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, One, 1, Also one, 2, Two",
            "2, Two, 1, One, 2, Also two"
    })
    @DisplayName("Test extractNumber when duplicates of 1 or 2")
    void extractNumber(String numOne, String descOne, String numTwo, String descTwo, String numThree, String descThree) {
        List<Task> in = Arrays.asList(
                new Task(numOne, descOne),
                new Task(numTwo, descTwo),
                new Task(numThree, descThree)
        );
        Set<String> out = FullSearch.extractNumber(in);
        assertThat(out, is(contains("1", "2")));
    }
}