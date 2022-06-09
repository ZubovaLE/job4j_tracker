package ru.job4j.lambda;

import java.util.function.UnaryOperator;

public class ScopeInsideSecondVersion {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            total = add(
                    el -> el + num, total
            );
        }
        System.out.println(total);
    }

    private static Integer add(UnaryOperator<Integer> calc, int total) {
        return calc.apply(total);
    }
}
