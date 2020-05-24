package ru.job4j.trainee.part003.stream;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    Map<String, Student> students = List.of(
            new Student(10, "Ivanov"),
            new Student(20, "Ivanova"),
            new Student(30, "Petrov"),
            new Student(40, "Petrova")
    ).stream()
            .distinct()
            .collect(Collectors.toMap(student -> student.getSurname(), student -> student));
}
