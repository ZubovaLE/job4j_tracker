package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public List<List<Student>> collectTo3Lists(List<Student> students, Predicate<Student> predict) {
        List<List<Student>> listOfGrades = new ArrayList<>();
        for (Grade x : Grade.values()) {
            listOfGrades.add(students.stream()
                    .filter(s -> s.getGrade() == x)
                    .sorted(Comparator.comparing(l -> l.getScore() <= 100 && l.getScore() > 80))
                    .collect(Collectors.toList()));
        }
        return listOfGrades;
    }
}
