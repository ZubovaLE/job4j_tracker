package ru.job4j.ex;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactorialTest {

    @Test
    @DisplayName("Test calc method when exception")
    void testCalcWhenException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> Factorial.calc(-5));
    }
}