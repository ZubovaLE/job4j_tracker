package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1Text123", "0Text123");
        List<String> alphabet = Arrays.asList("ccc", "a", "dddd", "bb", "eeeee");
        Comparator<String> cmpText = String::compareTo;
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        strings.sort(cmpText);
        System.out.println(strings);
        alphabet.sort(cmpDescSize);
        System.out.println(alphabet);
    }
}
