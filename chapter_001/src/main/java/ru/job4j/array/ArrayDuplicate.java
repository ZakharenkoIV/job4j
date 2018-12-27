package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        String container;
        int del = 0;
        for (int i = 0; i < array.length - del - 1; i++) {
            for (int ii = i; ii < array.length - del - 1; ii++) {
                if (array[i].equals(array[ii + 1])) {
                    container = array[array.length - 1 - del];
                    array[array.length - 1 - del] = array[ii + 1];
                    array[ii + 1] = container;
                    ii--;
                    del++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - del);
    }
}

