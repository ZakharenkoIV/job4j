package ru.job4j.trainee.part003.collection.comparators.job;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.trainee.part003.collection.Job;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobCombinedComparatorsTest {

    private Job job1 = new Job("Fix bug", 1);
    private Job job2 = new Job("Fix bug", 4);
    private Job job3 = new Job("Fix bug", 2);
    private Job job4 = new Job("X task", 3);
    private Job job5 = new Job("X task", 0);
    private List<Job> jobs;

    @Before
    public void setUp() {
        jobs = Arrays.asList(job1, job2, job3, job4, job5);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpDescNameDescPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        jobs.sort(cmpDescNameDescPriority);
        List<Job> actual = List.of(job4, job5, job2, job3, job1);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByDescNameAndAscPriority() {
        Comparator<Job> cmpDescNameAscPriority = new JobDescByName().thenComparing(new JobAscByPriority());
        jobs.sort(cmpDescNameAscPriority);
        List<Job> actual = List.of(job5, job4, job1, job3, job2);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByDescPriorityAndDescName() {
        Comparator<Job> cmpDescPriorityDescName = new JobDescByPriority().thenComparing(new JobDescByName());
        jobs.sort(cmpDescPriorityDescName);
        List<Job> actual = List.of(job2, job4, job3, job1, job5);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByDescPriorityAndAscName() {
        Comparator<Job> cmpDescPriorityAscName = new JobDescByPriority().thenComparing(new JobAscByName());
        jobs.sort(cmpDescPriorityAscName);
        List<Job> actual = List.of(job2, job4, job3, job1, job5);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByAscPriorityAndDescName() {
        Comparator<Job> cmpAscPriorityDescName = new JobAscByPriority().thenComparing(new JobDescByName());
        jobs.sort(cmpAscPriorityDescName);
        List<Job> actual = List.of(job5, job1, job3, job4, job2);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByAscPriorityAndAscName() {
        Comparator<Job> cmpAscPriorityAscName = new JobAscByPriority().thenComparing(new JobAscByName());
        jobs.sort(cmpAscPriorityAscName);
        List<Job> actual = List.of(job5, job1, job3, job4, job2);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpAscNameDescPriority = new JobAscByName().thenComparing(new JobDescByPriority());
        jobs.sort(cmpAscNameDescPriority);
        List<Job> actual = List.of(job2, job3, job1, job4, job5);
        assertThat(jobs, is(actual));
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpAscNameAscPriority = new JobAscByName().thenComparing(new JobAscByPriority());
        jobs.sort(cmpAscNameAscPriority);
        List<Job> actual = List.of(job1, job3, job2, job5, job4);
        assertThat(jobs, is(actual));
    }
}
