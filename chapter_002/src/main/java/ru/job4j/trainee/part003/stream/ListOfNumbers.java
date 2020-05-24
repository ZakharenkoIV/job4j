package ru.job4j.trainee.part003.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfNumbers {

    public List<Integer> matrixToList(List<List<Integer>> matrix) {
        return matrix.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
