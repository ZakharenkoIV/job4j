package ru.job4j.trainee.part003.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentFilterTest {

    @Test
    public void whenTakeListAnyStudentsThenListStudentsWhereScoreMoreBound() {
        List<Student> inputListStudents = List.of(
                new Student(10, "Ivanov"),
                new Student(90, "Sokolov"),
                new Student(20, "Ivanova"),
                new Student(30, "Petrov"),
                new Student(40, "Petrova"),
                new Student(80, "Popova"),
                new Student(50, "Sidorov"),
                new Student(70, "Popov"),
                new Student(60, "Sidorova"),
                new Student(100, "Sokolova"));
        StudentFilter studentFilter = new StudentFilter();
        List<Student> result = studentFilter.levelOf(inputListStudents, 65);
        List<Student> expected = List.of(
                new Student(100, "Sokolova"),
                new Student(90, "Sokolov"),
                new Student(80, "Popova"),
                new Student(70, "Popov"));
        assertThat(result, is(expected));
    }
}
