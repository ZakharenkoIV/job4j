package ru.job4j.trainee.part003.collection.comparators.job;

import ru.job4j.trainee.part003.collection.Job;

import java.util.Comparator;

public class JobAscByName implements Comparator<Job> {
    @Override
    public int compare(Job job, Job t1) {
        return job.getName().compareTo(t1.getName());
    }
}
