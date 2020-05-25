package ru.job4j.trainee.part003.bank;

import java.util.*;

public class BankService {
    private Map<BankUser, List<Account>> users = new HashMap<>();

    public void addUser(BankUser user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account newAccount) {
        BankUser foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> userAccounts = users.get(foundUser);
            if (!userAccounts.contains(newAccount)) {
                userAccounts.add(newAccount);
            }
        }
    }

    public BankUser findByPassport(String passport) {
        return users.keySet().stream()
                .filter(bankUser -> bankUser.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        BankUser foundUser = findByPassport(passport);
        Account desiredAccount = null;
        if (foundUser != null) {
            desiredAccount = users.get(foundUser).stream()
                    .filter(account1 -> account1.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return desiredAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}