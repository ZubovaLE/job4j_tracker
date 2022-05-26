package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class JobTest {

    @Test
    @DisplayName("Test JobAscByName comparator")
    void testJobAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int result = cmpAscByName.compare(
                new Job("Banana", 1),
                new Job("Apricot", 2)
        );
        assertThat(result, is(greaterThan(0)));
    }

    @Test
    @DisplayName("Test JobAscByPriority comparator")
    void testJobAscByPriority() {
        Comparator<Job> cmpAscByName = new JobAscByPriority();
        int result = cmpAscByName.compare(
                new Job("Banana", 1),
                new Job("Apricot", 2)
        );
        assertThat(result, is(lessThan(0)));
    }

    @Test
    @DisplayName("Test JobDescByName comparator")
    void testJobDescByName() {
        Comparator<Job> cmpAscByName = new JobDescByName();
        int result = cmpAscByName.compare(
                new Job("Banana", 1),
                new Job("Apricot", 2)
        );
        assertThat(result, is(lessThan(0)));
    }

    @Test
    @DisplayName("Test JobDescByPriority comparator")
    void testJobDescByPriority() {
        Comparator<Job> cmpAscByName = new JobDescByPriority();
        int result = cmpAscByName.compare(
                new Job("Banana", 1),
                new Job("Apricot", 2)
        );
        assertThat(result, is(greaterThan(0)));
    }

    @Test
    @DisplayName("Test Combined comparator")
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}