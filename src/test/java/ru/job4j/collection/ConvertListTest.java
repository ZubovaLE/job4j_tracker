package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ConvertListTest {

    @Test
    @DisplayName("Test convert when 2 arrays into list")
    public void whenTwoArraysIntoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{1});
        in.add(new int[]{2, 3});
        List<Integer> expect = Arrays.asList(1, 2, 3);
        List<Integer> out = ConvertList.convert(in);
        assertThat(out, is(expect));
    }

    @Test
    @DisplayName("Test convert when empty array and array with zeros into list")
    public void whenArrayWithZerosIntoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[]{});
        in.add(new int[2]);
        List<Integer> expect = Arrays.asList(0, 0);
        List<Integer> out = ConvertList.convert(in);
        assertThat(out, is(expect));
    }
}