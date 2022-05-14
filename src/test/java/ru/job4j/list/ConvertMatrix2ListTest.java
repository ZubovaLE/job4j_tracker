package ru.job4j.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConvertMatrix2ListTest {

    @Test
    @DisplayName("Test toList when 2x2 Array then List with 4 elements")
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        List<Integer> expect = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Test toList when 2x2 Array with zeros on row then List with 4 elements")
    public void when2on2ArrayWithZerosInRowThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {0, 0},
                {1, 2}
        };
        List<Integer> expect = Arrays.asList(0, 0, 1, 2);
        List<Integer> result = list.toList(input);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Test toList when zeros in 2x2 Array then List with 4 zero elements")
    public void when2on2ArrayWithZerosThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = new int[2][2];
        List<Integer> expect = Arrays.asList(0, 0, 0, 0);
        List<Integer> result = list.toList(input);
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("Test toList when array is empty then List is empty")
    public void whenEmptyArrayThenEmptyList() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = new int[][]{};
        List<Integer> result = list.toList(input);
        assertTrue(result.isEmpty());
    }
}