package ru.job4j.trainee.part003.collection.comparators.job;

import ru.job4j.trainee.part003.collection.Job;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {

    @Override
    public int compare(Job job, Job t1) {
        return Integer.compare(t1.getPriority(), job.getPriority());
    }
}
