package ru.job4j.oop;

public class Calculator {
    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public static int minus(int y) {
        return y - X;
    }

    public int multiply(int a) {
        return X * a;
    }

    public int divide(int y) {
        return y / X;
    }

    public int sumAllOperation(int a) {
        return minus(a) + divide(a) + sum(a) + multiply(a);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int result = calc.multiply(5);
        System.out.println("Call method multiply, result = " + result);
        result = calc.sumAllOperation(5);
        System.out.println("Call method sumAllOperations, result = " + result);
    }
}
