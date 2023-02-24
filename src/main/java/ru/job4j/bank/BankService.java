package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
        }

    public boolean deleteUser(String passport) {
        boolean rsl = false;
        if (users.containsKey(findByPassport(passport))) {
            users.remove(findByPassport(passport));
            rsl = true;
        }
        return rsl;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!getAccounts(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
            }
        }
        return rsl;

    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account srcUser = findByRequisite(srcPassport, srcRequisite);
        Account destUser = findByRequisite(destPassport, destRequisite);
        if (srcUser == null
                || destUser == null
                || srcUser.getBalance() < amount) {
            rsl = false;
        } else {
            srcUser.setBalance(srcUser.getBalance() - amount);
            destUser.setBalance(destUser.getBalance() + amount);
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}