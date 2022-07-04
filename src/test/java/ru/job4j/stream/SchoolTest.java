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
    @DisplayName("Test the collectToListsByGrade method when five grades")
    void testCollectToListsByGradeWhen5Grades() {
        Student firstInFirst = new Student(90, "firstInFirst", Grade.First);
        Student secondInFirst = new Student(85, "secondInFirst", Grade.First);
        Student thirdInFirst = new Student(50, "thirdInFirst", Grade.First);
        Student firstInSecond = new Student(90, "firstInSecond", Grade.Second);
        Student secondInSecond = new Student(20, "secondInSecond", Grade.Second);
        Student thirdInSecond = new Student(75, "thirdInSecond", Grade.Second);
        Student firstInThird = new Student(35, "firstInThird", Grade.Third);
        Student secondInThird = new Student(87, "secondInThird", Grade.Third);
        Student thirdInThird = new Student(98, "thirdInThird", Grade.Third);
        Student firstInFourth = new Student(13, "firstInFourth", Grade.Fourth);
        Student secondInFourth = new Student(97, "secondInFourth", Grade.Fourth);
        Student firstInFifth = new Student(12, "firstInFifth", Grade.Fifth);
        Student secondInFifth = new Student(71, "secondInFifth", Grade.Fifth);
        List<Student> students = List.of(
                firstInFirst, firstInFifth, firstInFourth, firstInSecond, firstInThird, thirdInSecond, thirdInThird,
                secondInFifth, secondInFourth, secondInSecond, secondInThird, secondInFirst, thirdInFirst
        );
        School sc = new School();
        Predicate<Student> pr = p -> p.getScore() <= 100 && p.getScore() > 70;
        List<List<Student>> rsl = sc.collectToListsByGrade(students, pr);
        List<List<Student>> expected = List.of(
                List.of(firstInFirst, secondInFirst),
                List.of(firstInSecond, thirdInSecond),
                List.of(thirdInThird, secondInThird),
                List.of(secondInFourth),
                List.of(secondInFifth)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    @DisplayName("Test the collectToListsByGrade method when no appropriate students then empty collection")
    void testCollectToListsByGradeWhenNoAppropriateStudentsThenEmptyList() {
        School sc = new School();
        Student first = new Student(56, "firstInFirst", Grade.First);
        Student second = new Student(54, "secondInFirst", Grade.First);
        Student third = new Student(50, "thirdInFirst", Grade.First);
        List<Student> students = List.of(first, second, third);
        Predicate<Student> pr = p -> p.getScore() <= 100 && p.getScore() > 70;
        List<List<Student>> rsl = sc.collectToListsByGrade(students, pr);
        List<List<Student>> expected = List.of(
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of()
        );
        assertThat(rsl, is(expected));
    }

    @Test
    @DisplayName("Test the collectToListsByProgress method")
    void testCollectToListsByProgress() {
        School sc = new School();

        Student first = new Student(10, "Surname1");
        Student second = new Student(40, "Surname2");
        Student third = new Student(49, "Surname3");
        Student fourth = new Student(50, "Surname4");
        Student fifth = new Student(65, "Surname5");
        Student sixth = new Student(69, "Surname6");
        Student seventh = new Student(70, "Surname7");
        Student eighth = new Student(90, "Surname8");
        Student ninth = new Student(98, "Surname9");

        List<Student> input = List.of(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth);
        Predicate<Student> firstRequire = p -> p.getScore() <= 100 && p.getScore() >= 70;
        Predicate<Student> secondRequire = p -> p.getScore() < 70 && p.getScore() >= 50;
        Predicate<Student> thirdRequire = p -> p.getScore() < 50 && p.getScore() > 0;
        List<Predicate<Student>> requirements = List.of(firstRequire, secondRequire, thirdRequire);
        List<List<Student>> rsl = sc.collectToListsByProgress(input, requirements);
        List<List<Student>> expected = List.of(
                List.of(ninth, eighth, seventh),
                List.of(sixth, fifth, fourth),
                List.of(third, second, first)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    @DisplayName("Test the collectToListsByProgress method")
    void testCollectToListsByProgressAndGrades() {
        School sc = new School();

        Student firstInFirst = new Student(90, "firstInFirst", Grade.First);
        Student secondInFirst = new Student(65, "secondInFirst", Grade.First);
        Student thirdInFirst = new Student(45, "thirdInFirst", Grade.First);
        Student fourthInFirst = new Student(98, "fourthInFirst", Grade.First);
        Student firstInSecond = new Student(90, "firstInSecond", Grade.Second);
        Student secondInSecond = new Student(65, "secondInSecond", Grade.Second);
        Student thirdInSecond = new Student(45, "thirdInSecond", Grade.Second);
        Student fourthInSecond = new Student(96, "fourthInSecond", Grade.Second);
        Student firstInThird = new Student(35, "firstInThird", Grade.Third);
        Student secondInThird = new Student(67, "secondInThird", Grade.Third);
        Student thirdInThird = new Student(68, "thirdInThird", Grade.Third);
        Student fourthInThird = new Student(98, "fourthInThird", Grade.Third);
        Student firstInFourth = new Student(13, "firstInFourth", Grade.Fourth);
        Student secondInFourth = new Student(97, "secondInFourth", Grade.Fourth);
        Student firstInFifth = new Student(12, "firstInFifth", Grade.Fifth);
        Student secondInFifth = new Student(71, "secondInFifth", Grade.Fifth);

        List<Student> students = List.of(
                firstInFirst, firstInFifth, firstInFourth, firstInSecond, firstInThird,
                thirdInSecond, thirdInThird, thirdInFirst,
                secondInFifth, secondInFourth, secondInSecond, secondInThird, secondInFirst,
                fourthInThird, fourthInSecond, fourthInFirst
        );

        Predicate<Student> firstRequire = p -> p.getScore() <= 100 && p.getScore() >= 70;
        Predicate<Student> secondRequire = p -> p.getScore() < 70 && p.getScore() >= 50;
        Predicate<Student> thirdRequire = p -> p.getScore() < 50 && p.getScore() > 0;
        List<Predicate<Student>> requirements = List.of(firstRequire, secondRequire, thirdRequire);

        List<List<Student>> rsl = sc.collectToListsByGradeAndProgress(students, requirements);

        List<List<Student>> expected = List.of(
                List.of(fourthInFirst, firstInFirst),
                List.of(secondInFirst),
                List.of(thirdInFirst),
                List.of(fourthInSecond, firstInSecond),
                List.of(secondInSecond),
                List.of(thirdInSecond),
                List.of(fourthInThird),
                List.of(thirdInThird, secondInThird),
                List.of(firstInThird),
                List.of(secondInFourth),
                List.of(),
                List.of(firstInFourth),
                List.of(secondInFifth),
                List.of(),
                List.of(firstInFifth)
        );
        assertThat(rsl, is(expected));
    }
}