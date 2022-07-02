package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private final String surname;
    private Grade grade;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public Student(int score, String surname, Grade grade) {
        this(score, surname);
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", surname='" + surname + '\'' +
                '}';
    }
}
