package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"Один", "Два", "Три", "Четыре", "Один", "Один", "Два", "Четыре", "Один", "Пять"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[]{"Один", "Два", "Три", "Четыре", "Пять"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenThereIsNoDuplicates() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] input = new String[]{"Пять", "Четыре", "Три", "Два", "Один"};
        String[] result = arrayDuplicate.remove(input);
        String[] expect = new String[]{"Пять", "Четыре", "Три", "Два", "Один"};
        assertThat(result, is(expect));
    }
}