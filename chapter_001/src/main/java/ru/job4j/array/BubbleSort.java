package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int removesTheLastCheck = 1; removesTheLastCheck < array.length; removesTheLastCheck++) {
            for (int index = 0, temporaryContainer; index < array.length - removesTheLastCheck; index++) {
                if (array[index] > array[index + 1]) {
                    temporaryContainer = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temporaryContainer;
                }
            }
        }
        return array;
    }
}
