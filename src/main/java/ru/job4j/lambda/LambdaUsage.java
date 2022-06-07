package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare: " + left + " with " + right);
            return Integer.compare(right.length(), left.length());
        };
        strings.sort(comparator);
        System.out.println("Сортировка в порядке убывания длин строк:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
