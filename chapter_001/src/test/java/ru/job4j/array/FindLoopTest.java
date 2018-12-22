package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{5, 12, 54};
        int value = 5;
        int result = findLoop.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh8ThenNotFound() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{5, 12, 54};
        int value = 8;
        int result = findLoop.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengh7Then3() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{5, 12, 7, 4, 8, 22};
        int value = 7;
        int result = findLoop.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }
}
