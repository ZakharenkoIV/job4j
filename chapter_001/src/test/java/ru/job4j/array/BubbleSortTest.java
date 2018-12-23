package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenArrayBubbleSorted() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[]{6, 7, 0, 1, 8, 5, 4, 5, 1};
        int[] expect = new int[]{0, 1, 1, 4, 5, 5, 6, 7, 8};
        int[] result = bubbleSort.sort(input);
        assertThat(result, is(expect));
    }
}
