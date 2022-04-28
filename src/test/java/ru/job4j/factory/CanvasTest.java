package ru.job4j.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasTest {
    String ln = System.lineSeparator();

    @Test
    @DisplayName("Test when triangle")
    void testWhenShapeIsTriangle() {
        StringBuilder expected = new StringBuilder();
        Input in = new StubInput(new String[]{"треугольник", "3", "4"});
        Output out = new StubOutput();
        Canvas canvas = new Canvas(out, in);
        canvas.init();
        expected.append("   *").append(ln).append("  * *").append(ln).append(" *   *").append(ln).append("*     *").append(ln).append("*******").
                append("Площадь фигуры равна: ").append("6.0");
        assertEquals(expected.toString(), out.toString());

    }

    @Test
    @DisplayName("Test when rectangle")
    void testWhenShapeIsRectangle() {
        StringBuilder expected = new StringBuilder();
        Input in = new StubInput(new String[]{"прямоугольник", "3", "4"});
        Output out = new StubOutput();
        Canvas canvas = new Canvas(out, in);
        canvas.init();
        expected.append("******").append(ln).append("*    *").append(ln).append("*    *").append(ln).append("******").
                append("Площадь фигуры равна: ").append("12.0");
        assertEquals(expected.toString(), out.toString());
    }
}