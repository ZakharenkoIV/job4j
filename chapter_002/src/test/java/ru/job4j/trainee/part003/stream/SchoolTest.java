package ru.job4j.trainee.part003.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    List<Student> class9A = List.of(
            new Student(10, "Ivanov"),
            new Student(20, "Ivanova"),
            new Student(30, "Petrov"),
            new Student(40, "Petrova"),
            new Student(50, "Sidorov"),
            new Student(60, "Sidorova"),
            new Student(70, "Popov"),
            new Student(80, "Popova"),
            new Student(90, "Sokolov"),
            new Student(100, "Sokolova"));
    School school = new School();

    @Test
    public void whenClassDivided70to100() {
        List<Student> class10A = school.collect(class9A, student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expected = List.of(
                new Student(70, "Popov"),
                new Student(80, "Popova"),
                new Student(90, "Sokolov"),
                new Student(100, "Sokolova"));
        assertThat(class10A, is(expected));
    }

    @Test
    public void whenClassDivided50to70() {
        List<Student> class10B = school.collect(class9A, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expected = List.of(
                new Student(50, "Sidorov"),
                new Student(60, "Sidorova"));
        assertThat(class10B, is(expected));
    }

    @Test
    public void whenClassDivided0to50() {
        List<Student> class10C = school.collect(class9A, student -> student.getScore() > 0 && student.getScore() < 50);
        List<Student> expected = List.of(
                new Student(10, "Ivanov"),
                new Student(20, "Ivanova"),
                new Student(30, "Petrov"),
                new Student(40, "Petrova"));
        assertThat(class10C, is(expected));
    }
}
