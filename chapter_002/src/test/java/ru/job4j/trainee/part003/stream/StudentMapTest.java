package ru.job4j.trainee.part003.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentMapTest {

    @Test
    public void whenClassDivided70to100() {
        List<Student> class10A = List.of(
                new Student(10, "Ivanov"),
                new Student(20, "Ivanov"),
                new Student(30, "Petrov"),
                new Student(40, "Petrov"));
        StudentMap studentMap = new StudentMap();
        Map<String, Student> result = studentMap.toMap(class10A);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student(10, "Ivanov"));
        expected.put("Petrov", new Student(30, "Petrov"));
        assertThat(result, is(expected));
    }
}
