package ru.job4j.trainee.part003.collection;

import ru.job4j.trainee.part003.collection.comparators.job.JobAscByPriority;
import ru.job4j.trainee.part003.collection.comparators.job.JobDescByName;
import ru.job4j.trainee.part003.collection.comparators.job.JobDescByPriority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0),
                new Job("X task", 3)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobAscByPriority()));
        System.out.println(jobs);
    }
}