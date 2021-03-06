package ru.job4j.trainee.part003.bank;

import java.util.*;

public class BankService {
    private Map<BankUser, List<Account>> users = new HashMap<>();

    public void addUser(BankUser user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account newAccount) {
        Optional<BankUser> foundUser = findByPassport(passport);
        if (foundUser.isPresent()) {
            List<Account> userAccounts = users.get(foundUser.get());
            if (!userAccounts.contains(newAccount)) {
                userAccounts.add(newAccount);
            }
        }
    }

    public Optional<BankUser> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(bankUser -> bankUser.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<BankUser> foundUser = findByPassport(passport);
        Optional<Account> desiredAccount = Optional.empty();
        if (foundUser.isPresent()) {
            desiredAccount = users.get(foundUser.get()).stream()
                    .filter(account1 -> account1.getRequisite().equals(requisite))
                    .findFirst();
        }
        return desiredAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}