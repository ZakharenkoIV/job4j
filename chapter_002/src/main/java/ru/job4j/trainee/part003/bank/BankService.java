package ru.job4j.trainee.part003.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        BankUser foundUser = null;
        for (BankUser user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                foundUser = user;
                break;
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        BankUser foundUser = findByPassport(passport);
        Account desiredAccount = null;
        if (foundUser != null) {
            List<Account> userAccounts = users.get(foundUser);
            for (Account account : userAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    desiredAccount = account;
                    break;
                }
            }
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