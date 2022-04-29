package ru.job4j.factory;

public class Canvas {
    private ShapeOperator shapeOperator;
    private final Output out;

    public Canvas(Output out) {
        this.out = out;
    }

    public void demonstrate(Input input) {
        this.shapeOperator.showInfo(out, input);
    }

    public void init(Input input) {
        String shape = input.askStr("Какую фигуру вы хотите построить: ");
        if (shape.equals("прямоугольник")) {
            shapeOperator = new RectangleOperator();
        } else if (shape.equals("треугольник")) {
            shapeOperator = new TriangleOperator();
        } else {
            shapeOperator = new SomeShapeOperator();
        }
        demonstrate(input);
    }
}
