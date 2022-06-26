package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AnalyzeTest {

    @Test
    @DisplayName("Test averageScore when single pupil with Math = 100 then result = 100")
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                )
        );
        assertThat(average, is(100D));
    }


    @Test
    @DisplayName("Test averageScore when math is 100 and Physics is 95 then result = 97.5D")
    public void whenSinglePupilWith2Subjects() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(
                                new Subject("Math", 100),
                                new Subject("Physics", 95)))
                )
        );
        assertThat(average, is(97.5D));
    }

    @Test
    @DisplayName("Test averageScore when two pupil")
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                )
        );
        assertThat(average, is(80D));
    }

    @Test
    @DisplayName("Test averageScoreBySubject when two pupil")
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 60))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                )
        );
        assertThat(average, is(List.of(
                new Tuple("Ivanov", 80D),
                new Tuple("Petrov", 60D)
        )));
    }

    @Test
    @DisplayName("Test averageScoreByPupil")
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                Stream.of(
                        new Pupil("Ivanov",
                                List.of(
                                        new Subject("Math", 100),
                                        new Subject("Lang", 100),
                                        new Subject("Philosophy", 100)
                                )
                        ),
                        new Pupil("Petrov",
                                List.of(
                                        new Subject("Math", 60),
                                        new Subject("Lang", 60),
                                        new Subject("Philosophy", 60)
                                )
                        )
                )
        );
        assertThat(average, is(List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D),
                new Tuple("Philosophy", 80D)
        )));
    }

    @Test
    @DisplayName("Test bestStudent")
    public void whenBestPupil() {
        Tuple best = Analyze.bestStudent(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                )
        );
        assertThat(best, is(new Tuple("Ivanov", 200D)));
    }


    @Test
    void bestSubject() {
    }
}