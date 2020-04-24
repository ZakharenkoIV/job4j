package ru.job4j.trainee.part003.bank;

import java.util.Objects;

public class BankUser {
    private String fullName;
    private String passport;

    public BankUser(String fullName, String passport) {
        this.fullName = fullName;
        this.passport = passport;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankUser bankUser = (BankUser) o;
        return Objects.equals(passport, bankUser.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
