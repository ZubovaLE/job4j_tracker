package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    /**
     * The method collect a collection of students with certain scores
     *
     * @param students- list of students
     * @param predict   - condition for students filtering
     * @return list of students
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    /**
     * The method convert list of students to lists of students with certain grade and certain scores
     *
     * @param students - list of students
     * @param predict  - condition for students filtering
     * @return list of lists of students
     */
    public List<List<Student>> collectToListsByGrade(List<Student> students, Predicate<Student> predict) {
        List<List<Student>> listOfStudentsByGrades = new ArrayList<>();
        for (Grade x : Grade.values()) {
            listOfStudentsByGrades.add(students.stream()
                    .filter(s -> s.getGrade() == x)
                    .filter(predict)
                    .collect(Collectors.toList()));
        }
        return listOfStudentsByGrades;
    }

    /**
     * The method convert list of students to lists of students with certain scores
     *
     * @param students     - list of students
     * @param requirements - list of predicates
     * @return list of lists of students
     */
    public List<List<Student>> collectToListsByProgress(List<Student> students, List<Predicate<Student>> requirements) {
        List<List<Student>> listOfStudentsByProgress = new ArrayList<>();
        for (Predicate<Student> predict : requirements) {
            listOfStudentsByProgress.add(students.stream()
                    .filter(predict)
                    .sorted(Comparator.comparingInt(Student::getScore).reversed())
                    .collect(Collectors.toList()));
        }
        return listOfStudentsByProgress;
    }

    /**
     * The method convert list of students to lists of students from different grades with certain scores
     *
     * @param students     - list of students
     * @param requirements - list of predicates
     * @return list of lists of students
     */
    public List<List<Student>> collectToListsByGradeAndProgress(List<Student> students, List<Predicate<Student>> requirements) {
        List<List<Student>> listOfStudentsByProgress = new ArrayList<>();
        for (Grade x : Grade.values()) {
            for (Predicate<Student> predict : requirements) {
                listOfStudentsByProgress.add(
                        students.stream()
                                .filter(s -> s.getGrade() == x)
                                .filter(predict)
                                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                                .collect(Collectors.toList()));
            }
        }
        return listOfStudentsByProgress;
    }
}
