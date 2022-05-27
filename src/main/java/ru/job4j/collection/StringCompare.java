package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int size = Math.min(left.length(), right.length());
        int rsl = 0;
        for (int i = 0; i < size; i++) {
            if (right.charAt(i) != left.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        if (rsl == 0) {
            return Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
