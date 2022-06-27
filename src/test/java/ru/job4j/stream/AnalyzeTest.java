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
    public void testAverageWhenSinglePupilWithOneSubject() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                )
        );
        assertThat(average, is(100D));
    }


    @Test
    @DisplayName("Test averageScore when single pupil with math = 100 and Physics = 95 then result = 97.5D")
    public void testAverageWhenSinglePupilWith2Subjects() {
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
    @DisplayName("Test averageScore when two pupils with one subject")
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
    @DisplayName("Test averageScoreBySubject when two pupils")
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
    @DisplayName("Test averageScoreBySubject when no pupils then result collection is empty")
    public void testAverageWhenNoPupils() {
        List<Tuple> average = Analyze.averageScoreBySubject(Stream.of());
        assertThat(average, is(List.of()));
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
    public void testBestPupil() {
        Tuple best = Analyze.bestStudent(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                )
        );
        assertThat(best, is(new Tuple("Ivanov", 200D)));
    }

    @Test
    @DisplayName("Test bestStudent when no pupils")
    public void testBestPupilWhenNoPupils() {
        Tuple best = Analyze.bestStudent(Stream.empty());
        assertThat(best, is(new Tuple("No one pupil is found", 0D)));
    }


    @Test
    public void testBestSubject() {
        Tuple best = Analyze.bestSubject(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100), new Subject("Lang", 40))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60), new Subject("Lang", 60)))
                )
        );
        assertThat(best, is(new Tuple("Math", 160D)));
    }

    @Test
    public void testBestSubjectWhenEmptyStream() {
        Tuple best = Analyze.bestSubject(Stream.of());
        assertThat(best, is(new Tuple("No one subject is found", 0D)));
    }

}