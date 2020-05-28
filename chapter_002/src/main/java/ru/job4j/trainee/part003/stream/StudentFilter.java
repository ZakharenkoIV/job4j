package ru.job4j.trainee.part003.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentFilter {

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.reverseOrder())
                .takeWhile(student -> student.getScore() > bound)
                .sorted()
                .collect(Collectors.toList());
    }
}
