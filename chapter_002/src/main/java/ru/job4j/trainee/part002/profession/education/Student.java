package ru.job4j.trainee.part002.profession.education;

import ru.job4j.trainee.part002.profession.Profession;

public class Student extends Profession {

    public Lesson lesson;

    public Student(String name, int lesson){
        this.setName(name);
        this.lesson.lesson = lesson;
    }

}
