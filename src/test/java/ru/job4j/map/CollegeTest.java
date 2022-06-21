package ru.job4j.map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CollegeTest {

    @Test
    @DisplayName("Test findByAccount when incorrect account then null")
    public void whenAccountIsOptionalEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findByAccount("000010"), is(Optional.empty()));
    }

    @Test
    @DisplayName("Test findByAccount when correct account")
    public void whenAccountIsOptionalNotEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findByAccount("000001").get().getGroup(), is("201-18-15"));
    }

    @Test
    @DisplayName("Test findBySubjectName when incorrect account then null")
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000010", "Sociology"), is(Optional.empty()));
    }

    @Test
    @DisplayName("Test findBySubjectName when incorrect name then null")
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000001", "Sociology"), is(Optional.empty()));
    }

    @Test
    @DisplayName("Test findBySubjectName when correct input")
    public void whenSubjectIsOptionalNotEmpty() {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subject("Economic", 75),
                        new Subject("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000002", "Sociology").get().getScore(), is(65));
    }
}