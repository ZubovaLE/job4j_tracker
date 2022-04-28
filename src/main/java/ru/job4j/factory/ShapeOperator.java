package ru.job4j.factory;

public abstract class ShapeOperator {

    public void showInfo(Output out, Input input) {
        Shape shape = createShape(input);
        out.println(shape.draw());
        out.println("Площадь фигуры равна: " + shape.square());
    }

    public abstract Shape createShape(Input input);
}
