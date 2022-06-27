package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    /**
     * The method finds an average value for all subjects for all pupils
     *
     * @param stream of pupils
     * @return average value for all subjects for all pupils
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * The method finds an average value of all subjects per pupil
     *
     * @param stream of pupils
     * @return a list of Tuple objects
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(value.getName(), value.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * The method finds an average value of all pupils for each subject
     *
     * @param stream of pupils
     * @return a list of Tuple objects
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }


    /**
     * The method finds the best pupil with the biggest score sum
     *
     * @param stream of pupils
     * @return a Tuple object
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(value -> new Tuple(value.getName(), value.getSubjects()
                        .stream()
                        .mapToDouble(Subject::getScore)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("No one pupil is found", 0D));
    }

    /**
     * The method finds the best subject with the biggest score sum for all pupils
     *
     * @param stream of pupils
     * @return a Tuple object
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.summingDouble((Subject::getScore))))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("No one subject is found", 0D));
    }
}
