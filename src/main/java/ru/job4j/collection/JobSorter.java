package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Comparator<Job> jobDescByNameLn = Comparator.comparingInt(j -> j.getName().length());
        Comparator<Job> jobDescByName = (j1, j2) -> j2.getName().compareTo(j1.getName());
        Comparator<Job> jobDescByPriority = (j1, j2) -> Integer.compare(j2.getPriority(), j1.getPriority());
        Comparator<Job> combine = jobDescByNameLn
                .thenComparing(jobDescByName)
                .thenComparing(jobDescByPriority);
        jobs.sort(combine);
        System.out.println(jobs);
    }
}
