package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    /**
     * The method collect a list of students with certain scores
     *
     * @param students- list of students
     * @param predict   - requirement for student filtering
     * @return list of students
     */
    public List<Student> collectToList(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    /**
     * The method convert list of students to list of lists by grade with certain scores
     *
     * @param students - list of students
     * @param predict  - condition for students filtering
     * @return list of lists of students
     */
    public List<List<Student>> collectListOfListsByGrade(List<Student> students, Predicate<Student> predict) {
        return Stream.of(Grade.values())
                .map(grade -> students.stream()
                        .filter(s -> s.getGrade() == grade)
                        .filter(predict)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    /**
     * The method convert list of students to list of lists by progress
     *
     * @param students     - list of students
     * @param requirements - list of predicates with requirements for separating students into classes
     * @return list of lists of students
     */
    public List<List<Student>> collectListOfListsByProgress(List<Student> students, List<Predicate<Student>> requirements) {
        return requirements.stream()
                .map(predicate -> students.stream()
                        .filter(predicate)
                        .sorted(Comparator.comparingInt(Student::getScore).reversed())
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    /**
     * The method convert list of students to list of lists by grades with lists by certain scores
     *
     * @param students     - list of students
     * @param requirements - list of predicates with requirements for separating students into classes
     * @return list of lists with lists of students
     */
    public List<List<List<Student>>> collectListOfListsByGradeWithListsByProgress(List<Student> students, List<Predicate<Student>> requirements) {
        return Stream.of(Grade.values())
                .map(grade -> requirements.stream()
                        .map(r -> students.stream()
                                .filter(s -> s.getGrade() == grade)
                                .filter(r)
                                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                                .collect(Collectors.toList()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
