package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AnalyzeTest {

    @Test
    @DisplayName("Test averageScore when math is 100 and russian is 95 then result = 97.5")
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Russian", 95)))
                )
        );
        assertThat(average, is(97.5D));
    }

    @Test
    void averageScoreBySubject() {
    }

    @Test
    void averageScoreByPupil() {
    }

    @Test
    void bestStudent() {
    }

    @Test
    void bestSubject() {
    }
}