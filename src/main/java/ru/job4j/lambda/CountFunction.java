package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class CountFunction {
    List<Double> diapason(int start, int end, UnaryOperator<Double> operator) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(operator.apply((double) i));
        }
        return list;
    }
}
