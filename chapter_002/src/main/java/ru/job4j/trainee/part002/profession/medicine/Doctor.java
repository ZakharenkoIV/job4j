package ru.job4j.trainee.part002.profession.medicine;

import ru.job4j.trainee.part002.profession.Profession;

public class Doctor extends Profession {

    public Doctor(String name) {
        this.setName(name);
        this.setProfession("Doctor");
    }

    public Diagnose heal(Patient patient) {
        return patient.diagnose;
    }
}
