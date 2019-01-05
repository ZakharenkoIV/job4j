package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int remove = 1; remove < array.length; remove++) {
            for (int index = 0, container; index < array.length - remove; index++) {
                if (array[index] > array[index + 1]) {
                    container = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = container;
                }
            }
        }
        return array;
    }
}
