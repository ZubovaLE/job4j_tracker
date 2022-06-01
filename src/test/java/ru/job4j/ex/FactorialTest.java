package ru.job4j.ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    @DisplayName("Test calc method when exception")
    void testCalcWhenException() {
       assertThrows(IllegalArgumentException.class, () -> Factorial.calc(-5));
    }
}