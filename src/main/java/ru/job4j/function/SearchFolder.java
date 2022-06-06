package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> resultList = new ArrayList<>();
        for (Folder el : list) {
            if (pred.test(el)) {
                resultList.add(el);
            }
        }
        return resultList;
    }
}
