package ru.job4j.trainee.part003.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int number : array) {
                result.add(number);
            }
        }
        return result;
    }
}