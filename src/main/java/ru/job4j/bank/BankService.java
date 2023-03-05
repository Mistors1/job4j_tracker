package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Класс описывает работу банка с многими пользователями
 * @author Mistors
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *Метод принимает на вход пользователя
     *и добавляет его если такого пользователя еще нет,
     * @param user пользователь которого добавляют в базу
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
        }

    /**
     * Метод осуществляет поиск пользователя по пасспорту
     * и удаляет его
     * @param passport пасспорт по которму осуществляется поиск
     * @return возращает true если пользователь удалён
     */
    public boolean deleteUser(String passport) {
        boolean rsl = false;
        if (users.containsKey(findByPassport(passport))) {
            users.remove(findByPassport(passport));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод осуществляет поиск пользователя и добавляет ему счет
     * если таковой отсутсвует
     * @param passport пасспорт по которому осуществляется поиск пользователя
     * @param account номер счета по которому проверятся есть ли такой у пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (!getAccounts(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод осуществляет поиск пользователя по пасспорту
     * @param passport пасспорт по которому осуществляется поиск
     * @return возвращает пользователя со всеми его данными
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод осуществляет поиск конкретного счета
     * @param passport пасспорт по которому ищут пользователя
     * @param requisite номер счета который ищут у пользователя
     * @return возращает данные найденого счета
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
         return users.get(user).stream()
                 .filter(account -> account.getRequisite().equals(requisite))
                 .findFirst()
                 .orElse(null);
        }
        return null;
    }

    /**
     * Метод осуществляет перевод денег с одного счета на другой
     * @param srcPassport пасспорт пользователя который переводит
     * @param srcRequisite счет пользовотеля который переводит
     * @param destPassport пасспорт пользователя которому переводят
     * @param destRequisite счет пользователя которому переводят
     * @param amount количество переводимых средств
     * @return возвращает true при успешном переводе
     */
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

    /**
     * Метод позволяет получить список всех счетов пользователя
     * @param user пользователь у которого смотрят счета
     * @return возвращает все счета пользователя в виде списка
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}