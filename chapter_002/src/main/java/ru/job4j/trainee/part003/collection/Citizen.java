package ru.job4j.trainee.part003.collection;

import java.util.Objects;

public class Citizen {
    private String passport;
    private String userName;

    public Citizen(String passport, String userName) {
        this.passport = passport;
        this.userName = userName;
    }

    public String getPassport() {
        return passport;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) o;
        return Objects.equals(passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}

