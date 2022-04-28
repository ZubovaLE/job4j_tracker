package ru.job4j.factory;

public class TriangleOperator extends ShapeOperator {
    @Override
    public Shape createShape(Input input) {
        int a = input.askInt("Введите длину основания треугольника: ");
        int h = input.askInt("Введите высоту треугольника: ");
        return new Triangle(a, h);
    }
}
