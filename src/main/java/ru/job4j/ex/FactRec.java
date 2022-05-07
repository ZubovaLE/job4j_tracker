package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N could not be less then 0");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return calc(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
