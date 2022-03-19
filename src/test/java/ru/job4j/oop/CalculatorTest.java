package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Test sum method when in = 5 then result = 5")
    void testSumWhenIn5Then5() {
        int in = 5;
        int out = Calculator.sum(in);
        int expected = 10;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test minus method when in = 7, then result = 2")
    void testMinusWhenIn7Then2() {
        int in = 7;
        int out = Calculator.minus(in);
        int expected = 2;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test multiple method when in = 3, then result = 15")
    void testMultiplyWhenIn3Then15() {
        int in = 3;
        Calculator calc = new Calculator();
        int out = calc.multiply(in);
        int expected = 15;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test divide method when in = 15, then result = 3")
    void testDivideWhenIn15Then3() {
        int in = 15;
        Calculator calc = new Calculator();
        int out = calc.divide(in);
        int expected = 3;
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test sumAllOperations method when in = 3, then result = 36")
    void testSumAllOperationWhenIn3Then36() {
        int in = 5;
        Calculator calc = new Calculator();
        int out = calc.sumAllOperation(in);
        int expected = 36;
        assertEquals(expected, out);
    }
}