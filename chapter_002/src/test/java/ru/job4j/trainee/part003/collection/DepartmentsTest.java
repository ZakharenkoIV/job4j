package ru.job4j.trainee.part003.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK1/SSK1");
        List<String> result = Departments.fillGaps(input);
        List<String> expect = Arrays.asList("K1", "K1/SK1", "K1/SK1/SSK1", "K2", "K2/SK1", "K2/SK1/SSK1");
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortDesc() {
        List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK1/SSK1");
        List<String> result = Departments.fillGaps(input);
        Departments.sortDesc(result);
        List<String> expect = Arrays.asList("K2", "K2/SK1", "K2/SK1/SSK1", "K1", "K1/SK1", "K1/SK1/SSK1");
        assertThat(result, is(expect));
    }
}