package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("Test method distance when x1 = 0, y1 = 0, x2 = 2, y2 =0")
    void distanceWhenX1Is0Y1Is0X2Is2Y2Is0() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2;
        double out = a.distance(b);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Test method distance when x1 = 0, y1 = 0, x2 = 0, y2 = 2")
    void distanceWhenX1Is0Y1Is0X2Is0Y2Is2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double expected = 2;
        double out = a.distance(b);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Test method distance when x1 = 0, y1 = 0, x2 = 0, y2 = 0")
    void distanceWhenX1Is0Y1Is0X2Is0Y2Is0() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double expected = 0;
        double out = a.distance(b);
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }
}