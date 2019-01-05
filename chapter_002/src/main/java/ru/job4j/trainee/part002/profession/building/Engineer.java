package ru.job4j.trainee.part002.profession.building;

import ru.job4j.trainee.part002.profession.Profession;

public class Engineer extends Profession {
    public Engineer(String name) {
        this.setName(name);
        this.setProfession("Engineer");
    }

    public  Builder building(House house) {
        return house.builder;
    }
}
