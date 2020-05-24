package ru.job4j.trainee.part003.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListOfNumbersTest {

    @Test
    public void whenMatrixIntegersThenListIntegers() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        List<Integer> result = listOfNumbers.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}
