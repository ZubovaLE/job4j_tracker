package ru.job4j.factory;

public class Rectangle implements Shape {
    int a;
    int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String draw() {
        StringBuilder buffer = new StringBuilder();
        String ln = System.lineSeparator();
        buffer.append("******").append(ln).append("*    *").append(ln).append("*    *").append(ln).append("******");
        return buffer.toString();
    }

    @Override
    public double square() {
        return a * b;
    }
}
