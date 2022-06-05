package ru.job4j.factory;

public abstract class ShapeOperator {

    public void showInfo(Output out, Input input) {
        Shape shape = createShape(input);
        if (shape != null) {
            out.println(shape.draw());
            out.println("Площадь фигуры равна: " + shape.square());
        } else {
            out.println("Фигура не определена");
        }
    }

    public abstract Shape createShape(Input input);
}
