package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(value.getName(),
                        value.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        Pupil bestStudent = stream
                .max(Comparator.comparingDouble(t -> t.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .orElse(new Pupil("No name", List.of(new Subject("No subject", 0))));
        return new Tuple(bestStudent.getName(), bestStudent.getSubjects().stream().mapToDouble(Subject::getScore).sum());
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
