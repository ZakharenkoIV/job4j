package ru.job4j.trainee.part002.profession.medicine;

import ru.job4j.trainee.part002.profession.Profession;

public class Patient extends Profession {
    public Diagnose diagnose;

    public Patient(String name, String diagnose) {
        this.setName(name);
        this.diagnose = new Diagnose(diagnose);
    }
}
