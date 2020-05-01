package ru.job4j.trainee.part003.collection.comparators.job;

import org.junit.Test;
import ru.job4j.trainee.part003.collection.Job;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobAscByNameTest {

    @Test
    public void jobAscByNameTest() {
        Job job1 = new Job("C", 1);
        Job job2 = new Job("B", 2);
        Job job3 = new Job("A", 3);
        List<Job> jobList = new ArrayList<>(List.of(job2, job1, job3));
        jobList.sort(new JobAscByName());
        List<Job> expected = List.of(job3, job2, job1);
        assertThat(jobList, is(expected));
    }
}
