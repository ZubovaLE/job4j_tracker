package ru.job4j.factory;

public class RectangleOperator extends ShapeOperator {

    @Override
    public Shape createShape(Input input) {
        int a = input.askInt("Введите ширину прямоугольника: ");
        int b = input.askInt("Введите длину прямоугольника: ");
        return new Rectangle(a, b);
    }
}
