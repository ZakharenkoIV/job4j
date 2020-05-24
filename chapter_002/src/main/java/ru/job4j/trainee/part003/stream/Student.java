package ru.job4j.trainee.part003.stream;

import java.util.Objects;

public class Student {
    private String surname;
    private int score;

    public Student() {
    }

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        assert score > 0 & score <= 100 : "score = " + score;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }
}
