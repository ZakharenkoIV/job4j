package ru.job4j.trainee.part003.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public Map<String, Student> toMap(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(Student::getSurname, student -> student, (existing, replacement) -> existing));
    }
}
