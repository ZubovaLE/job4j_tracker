package ru.job4j.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CountFunctionTest {

    @ParameterizedTest
    @DisplayName("Test diapason when linear function 2 * x + 1")
    @CsvSource(value = {
            "5, 8, 11, 13, 15",
            "-5, -2, -9, -7, -5",
            "0, 3, 1, 3, 5"
    })
    void testDiapasonWhenLinearFunction(int start, int end, double one, double two, double three) {
        CountFunction func = new CountFunction();
        List<Double> result = func.diapason(start, end, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(one, two, three);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @DisplayName("Test diapason when squared function x * x + 1")
    @CsvSource(value = {
            "1, 4, 2, 5, 10",
            "-5, -2, 26, 17, 10",
            "0, 3, 1, 2, 5"
    })
    void testDiapasonWhenSquaredFunction(int start, int end, double one, double two, double three) {
        CountFunction func = new CountFunction();
        List<Double> result = func.diapason(start, end, x -> x * x + 1);
        List<Double> expected = Arrays.asList(one, two, three);
        assertThat(result, is(expected));
    }

    @ParameterizedTest
    @DisplayName("Test diapason when exponential function a^x")
    @CsvSource(value = {
            "1, 4, 2, 2, 4, 8",
            "-2, 1, -2, 0.25, -0.5, 1",
            "0, 3, 3, 1, 3, 9"
    })
    void testDiapasonWhenExponentialFunction(int start, int end, double a, double one, double two, double three) {
        CountFunction func = new CountFunction();
        List<Double> result = func.diapason(start, end, x -> Math.pow(a, x));
        List<Double> expected = Arrays.asList(one, two, three);
        assertThat(result, is(expected));
    }
}