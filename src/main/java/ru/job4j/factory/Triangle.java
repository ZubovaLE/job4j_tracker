package ru.job4j.factory;

public class Triangle implements Shape {
    int a;
    int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String draw() {
        StringBuilder buffer = new StringBuilder();
        String ln = System.lineSeparator();
        buffer.append("   *").append(ln).append("  * *").append(ln).append(" *   *").append(ln).append("*     *").append(ln).append("*******");
        return buffer.toString();
    }

    @Override
    public double square() {
        return 0.5 * a * h;
    }
}
