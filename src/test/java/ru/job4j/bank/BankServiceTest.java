package ru.job4j.bank;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BankServiceTest {
    @Test
    void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434")).isEqualTo(user);
    }

    @Test
    void deleteUserIsTrue() {
        User first = new User("3434", "Petr Arsentev");
        User second = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        assertThat(bank.deleteUser("3434")).isTrue();
    }

    @Test
    void deleteUserIsFalse() {
        User first = new User("3434", "Petr Arsentev");
        User second = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(first);
        bank.addUser(second);
        assertThat(bank.deleteUser("343434")).isFalse();
    }

    @Test
    void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("34", "5546")).isNull();
    }

    @Test
    void whenEnterValidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Account expected = new Account("5546", 1500);
        assertThat(bank.findByRequisite("3434", "5546")).isEqualTo(expected);
    }

    @Test
    void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    void addDuplicateAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("5546", 500D));
        assertThat(bank.getAccounts(user)).hasSize(1);
    }

    @Test
    void transferMoneyOk() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance()).isEqualTo(200D);
    }

    @Test
    void transferMoneySourceNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "554", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(150D);
    }

    @Test
    void transferMoneyDontHaveEnoughMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 300D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance()).isEqualTo(50D);
    }

    @Test
    void transferMoneyDestinationIsNull() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "1131", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "5546").getBalance()).isEqualTo(150D);
    }
}