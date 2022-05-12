package ru.job4j.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @ParameterizedTest
    @CsvSource(value = {
            "low, 5, urgent, 1, middle, 3",
            "low, 5, urgent, 1, secondUrgent, 1",
            "firstMiddle, 4, urgent, 0, secondMiddle, 4",
            "middle, 5, urgent, 4, low, 7"
    })
    void whenHigherPriority(String descOne, int priorityOne, String descTwo,
                                   int priorityTwo, String descThree, int priorityThree) {
        PriorityQueue queue = new PriorityQueue();
        Task one = new Task(descOne, priorityOne);
        queue.put(one);
        Task two = new Task(descTwo, priorityTwo);
        queue.put(two);
        Task three = new Task(descThree, priorityThree);
        queue.put(three);
        Task result = queue.take();
        assertThat(result, samePropertyValuesAs(two));
    }
}