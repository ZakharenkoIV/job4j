package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(0, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(1, 0);
        assertThat(result, is(1));
    }

    @Test
    public void whenFirstEqualSecond() {
        Max maxim = new Max();
        int result = maxim.max(0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void whenOllEquels() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(0, 0, 0);
        assertThat(result, is(0));
    }

    @Test
    public void whenFirstMore() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(1, 0, 0);
        assertThat(result, is(1));
    }

    @Test
    public void whenSecondMore() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(0, 1, 0);
        assertThat(result, is(1));
    }

    @Test
    public void whenThirdMore() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(0, 0, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenFirstEndSecondMore() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(1, 1, 0);
        assertThat(result, is(1));
    }

    @Test
    public void whenSecondEndThirdMore() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(0, 1, 1);
        assertThat(result, is(1));
    }

    @Test
    public void whenFirstEndThirdMore() {
        Max maxim = new Max();
        int result = maxim.maxOfTheThree(1, 0, 1);
        assertThat(result, is(1));
    }
}