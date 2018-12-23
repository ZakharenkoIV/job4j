package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenQuantityEven() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = turn.back(array);
        int[] expect = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
@Test
    public void whenQuantityOdd() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = turn.back(array);
        int[] expect = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }
}
