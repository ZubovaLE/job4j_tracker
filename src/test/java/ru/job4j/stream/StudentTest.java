package ru.job4j.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StudentTest {
    Student student = new Student(60, "Ivanov");

    @Test
    @DisplayName("Test getScore")
    void getScore() {
        int expected = student.getScore();
        assertThat(expected, is(60));
    }

    @Test
    @DisplayName("Test getSurname")
    void getSurname() {
        String expected = student.getSurname();
        assertThat(expected, is("Ivanov"));
    }

    @Test
    @DisplayName("Test setScore")
    void setScore() {
        student.setScore(80);
        int expected = student.getScore();
        assertThat(expected, is(80));
    }

    @Test
    @DisplayName("Test equals")
    void testEquals() {
        Student first = new Student(80, "Ivanov");
        Student second = new Student(80, "Ivanov");
        assertThat(first.equals(second), is(true));
    }
}