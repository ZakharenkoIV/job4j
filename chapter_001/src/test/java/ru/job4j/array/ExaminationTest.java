package ru.job4j.array;

import org.junit.Test;
import ru.job4j.Examination;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExaminationTest {
    @Test
    public void whenTwoDifferentInLengthSortedArraysThenOneCombinedSortedArray() {
        int[] firstArray = new int[]{2, 4, 5, 6, 8, 11, 25};
        int[] secondArray = new int[]{1, 3, 5, 5, 9, 11, 40, 50, 60, 70};
        Examination examination = new Examination();
        int[] result = examination.addSortedArray(firstArray, secondArray);
        int[] expect = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 8, 9, 11, 11, 25, 40, 50, 60, 70};
        assertThat(result, is(expect));
    }

    @Test
    public void whenOption1TwoEqualOnLengthSortedArraysThenOneCombinedSortedArray() {
        int[] firstArray = new int[]{1, 3, 5, 5, 9, 11, 40};
        int[] secondArray = new int[]{2, 4, 5, 6, 8, 11, 25};
        Examination examination = new Examination();
        int[] result = examination.addSortedArray(firstArray, secondArray);
        int[] expect = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 8, 9, 11, 11, 25, 40};
        assertThat(result, is(expect));
    }

    @Test
    public void whenOption2TwoEqualOnLengthSortedArraysThenOneCombinedSortedArray() {
        int[] firstArray = new int[]{2, 4, 5, 6, 8, 11, 25};
        int[] secondArray = new int[]{1, 3, 5, 5, 9, 11, 40};
        Examination examination = new Examination();
        int[] result = examination.addSortedArray(firstArray, secondArray);
        int[] expect = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 8, 9, 11, 11, 25, 40};
        assertThat(result, is(expect));
    }
}
