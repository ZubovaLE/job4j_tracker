package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMethods {
    public static int[] arrayAfterMapping(int[] array) {
        return Arrays.stream(array)
                .map(x -> x * 3)
                .toArray();
    }

    public static List<Integer> listAfterMapping(List<Integer> list) {
        return list.stream()
                .map(l -> l * l)
                .collect(Collectors.toList());
    }

    public static int[] arrayAfterFiltering(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .toArray();
    }

    public static List<Integer> listAfterFiltering(List<Integer> list) {
        return list.stream()
                .filter(l -> l > 2 && l < 6)
                .collect(Collectors.toList());
    }

    public static int arrayAfterReducing(int[] array) {
        return Arrays.stream(array)
                .reduce(Integer::sum)
                .getAsInt();
    }

    public static int listAfterReducing(List<Integer> list) {
        return list.stream()
                .map(l -> l + 1)
                .reduce((a, b) -> a * b)
                .get();
    }

    public static int[] arrayAfterFlatMapping(int[] array) {
        return Arrays.stream(array)
                .limit(4)
                .flatMap(x -> IntStream.range(0, 3))
                .toArray();
    }
}
