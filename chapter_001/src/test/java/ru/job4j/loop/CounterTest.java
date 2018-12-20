package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CounterTest {

    @Test
    public void whenStartLessFinish() {
        Counter counter = new Counter();
        int result = counter.add(0, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenStartEqualFinish() {
        Counter counter = new Counter();
        int result = counter.add(0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void whenStartMoreFinish() {
        Counter counter = new Counter();
        int result = counter.add(2, 0);
        assertThat(result, is(-1));
    }
}
