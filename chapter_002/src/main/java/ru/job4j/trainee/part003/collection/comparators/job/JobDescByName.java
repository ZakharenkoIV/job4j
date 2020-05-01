package ru.job4j.trainee.part003.collection.comparators.job;

import ru.job4j.trainee.part003.collection.Job;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {

    @Override
    public int compare(Job job, Job t1) {
        return t1.getName().compareTo(job.getName());
    }
}
