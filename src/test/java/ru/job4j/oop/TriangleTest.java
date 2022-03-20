package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private final Point a = new Point(0, 0);
    private final Point b = new Point(4, 0);
    private final Point c = new Point(0, 4);


    @Test
    @DisplayName("Test semiPerimeter method when a = 4, b = 5.66, c = 4, then result = 4")
    public void testSemiPerimeterWhenAIs4BIs5Point66CIs4Then4() {
        Triangle triangle = new Triangle(a, b, c);
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        double out = triangle.semiPerimeter(ab, bc, ac);
        double expected = 6.83;
        double eps = 0.01;
        assertEquals(expected, out, eps);
    }

    @Test
    @DisplayName("Test exist method when a = 4, b = 5.66, c = 4, then result is true")
    public void testExistWhenAIs4BIs5Point66CIs4ThenTrue() {
        Triangle triangle = new Triangle(a, b, c);
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        assertTrue(triangle.exist(ab, bc, ac));
    }

    @Test
    @DisplayName("Test isGreater method when a = 4, b = 5.66, c = 4, then result is true")
    public void testIsGreaterWhenAIs4BIs5Point66CIs4ThenTrue() {
        Triangle triangle = new Triangle(a, b, c);
        double ab = a.distance(b);
        double bc = b.distance(c);
        double ac = a.distance(c);
        assertTrue(triangle.isGreater(ab + bc, ac));
    }

    @Test
    @DisplayName("Test area method when a = 4, b = 5.66, c = 4, then result = 8")
    public void testAreaWhen00and40and04Then8() {
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        double expected = 8;
        double eps = 0.01;
        assertEquals(expected, rsl, eps);
    }
}