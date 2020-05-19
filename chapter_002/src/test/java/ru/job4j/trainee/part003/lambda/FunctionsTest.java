package ru.job4j.trainee.part003.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FunctionsTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functions function = new Functions();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        Functions function = new Functions();
        List<Double> result = function.diapason(2, 5, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(9D, 19D, 33D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        Functions function = new Functions();
        List<Double> result = function.diapason(1, 4, x -> 2 * Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(5D, 9D, 17D);
        assertThat(result, is(expected));
    }
}
