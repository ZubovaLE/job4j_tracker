package ru.job4j.factory;

import java.util.Scanner;

public class Canvas {
    private final ShapeOperator shapeOperator;

    public Canvas(ShapeOperator shapeOperator) {
        this.shapeOperator = shapeOperator;
    }

    public void demonstrate() {
        this.shapeOperator.showInfo();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeOperator operator;
        System.out.println("Какую фигуру вы хотите построить: ");
        String shape = input.nextLine();
        if (shape.equals("прямоугольник")) {
            operator = new RectangleOperator();
        } else if (shape.equals("треугольник")) {
            operator = new TriangleOperator();
        } else {
            operator = null;
            System.out.println("Error");
        }
        Canvas canvas = new Canvas(operator);
        canvas.demonstrate();
    }
}
