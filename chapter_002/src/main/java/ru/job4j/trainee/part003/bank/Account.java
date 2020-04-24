package ru.job4j.trainee.part003.bank;

import java.util.Objects;

public class Account {
    private double balance;
    private String requisite;

    public Account(String requisite, double balance) {
        this.balance = balance;
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
