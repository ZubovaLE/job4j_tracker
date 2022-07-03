package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SchoolTest {

    @Test
    @DisplayName("Test when 70 <= score <= 100")
    void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = p -> p.getScore() <= 100 && p.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    @DisplayName("Test when 50 <= score < 70")
    void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = p -> p.getScore() < 70 && p.getScore() >= 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    @DisplayName("Test when 0 < score < 50")
    void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = p -> p.getScore() < 50 && p.getScore() > 0;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    @DisplayName("Test when 70 <= score <= 100")
    void whenCollectGrades() {
        List<Student> students = List.of(
                new Student(90, "Surname1", Grade.First),
                new Student(85, "Surname4", Grade.First),
                new Student(90, "Surname5", Grade.Second),
                new Student(90, "Surname7", Grade.Fifth),
                new Student(90, "Surname9", Grade.Third),
                new Student(90, "Surname10", Grade.Fourth)
        );
        School sc = new School();
        Predicate<Student> pr = p -> p.getScore() <= 100 && p.getScore() > 80;
        List<List<Student>> rsl = sc.collectToLists(students, pr);
        List<List<Student>> expected = List.of(List.of(
                        new Student(90, "Surname1", Grade.First), new Student(85, "Surname4", Grade.First)),
                List.of(new Student(90, "Surname5", Grade.Second)),
                List.of(new Student(90, "Surname9", Grade.Third)),
                List.of(new Student(90, "Surname10", Grade.Fourth)),
                List.of(new Student(90, "Surname7", Grade.Fifth))
        );
        assertThat(rsl, is(expected));
    }

//    @Test
//    @DisplayName("Test when 70 <= score <= 100")
//    void whenCollectGradesd() {
//        Student firstInFirst = new Student(90, "Surname1", Grade.First);
//        Student secondInFirst = new Student(85, "Surname4", Grade.First);
//        Student firstInSecond = new Student(90, "Surname5", Grade.Second);
//        Student secondInSecond = new Student(90, "Surname5", Grade.Second);
//        Student firstInThird = new Student(90, "Surname9", Grade.Third);
//        Student secondInThird = new Student(90, "Surname9", Grade.Third);
//        Student firstInFourth = new Student(90, "Surname10", Grade.Fourth);
//        Student secondInFourth = new Student(90, "Surname10", Grade.Fourth);
//        Student firstInFifth = new Student(90, "Surname10", Grade.Fourth);
//        Student secondInFifth = new Student(90, "Surname10", Grade.Fourth);
//        List<Student> students = List.of(firstInFirst, firstInFifth, firstInFourth, firstInSecond, firstInSecond,
//                secondInFifth, secondInFourth, secondInSecond, secondInThird, secondInFirst
//        );
//        School sc = new School();
//        Predicate<Student> pr = p -> p.getScore() <= 100 && p.getScore() > 80;
//        List<List<Student>> rsl = sc.collectToLists(students, pr);
//        List<List<Student>> expected = List.of(List.of(
//                        new Student(90, "Surname1", Grade.First), new Student(85, "Surname4", Grade.First)),
//                List.of(new Student(90, "Surname5", Grade.Second)),
//                List.of(new Student(90, "Surname9", Grade.Third)),
//                List.of(new Student(90, "Surname10", Grade.Fourth)),
//                List.of(new Student(90, "Surname7", Grade.Fifth))
//        );
//        assertThat(rsl, is(expected));
//    }
}