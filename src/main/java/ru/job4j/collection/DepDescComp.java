package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String first = !o1.contains("/") ? o1 : o1.split("/")[0];
        String second = !o2.contains("/") ? o2 : o2.split("/")[0];
        int rst = second.compareTo(first);
        if (rst == 0) {
            rst = o1.compareTo(o2);
        }
        return rst;
    }
}
