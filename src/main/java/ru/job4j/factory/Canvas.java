package ru.job4j.factory;

public class Canvas {
    private ShapeOperator shapeOperator;
    private final Output out;
    private final Input input;

    public Canvas(Output out, Input input) {
        this.out = out;
        this.input = input;
    }

    public void demonstrate() {
        this.shapeOperator.showInfo(out, input);
    }

    public void init() {
        String shape = input.askStr("Какую фигуру вы хотите построить: ");
        if (shape.equals("прямоугольник")) {
            shapeOperator = new RectangleOperator();
        } else if (shape.equals("треугольник")) {
            shapeOperator = new TriangleOperator();
        } else {
            shapeOperator = null;
            out.println("Error");
        }
        demonstrate();
    }
}
