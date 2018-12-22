package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBound1then1() {
        int bound = 1;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[]{1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound3thenTo9() {
        int bound = 3;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(result, is(expect));
    }

    @Test
    public void whenBound5thenTo100() {
        int bound = 10;
        Square square = new Square();
        int[] result = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        assertThat(result, is(expect));
    }
}
