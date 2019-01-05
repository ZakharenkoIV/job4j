package ru.job4j.trainee.part002.profession.education;

import ru.job4j.trainee.part002.profession.Profession;

public class Teacher extends Profession {

    public Teacher(String name) {
        this.setName(name);
        this.setProfession("Teacher");
    }

    public Lesson teach(Student student) {
        return student.lesson;
    }
}
