package ru.job4j.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    @DisplayName("Test addUser when new user")
    public void addUserWhenUserIsAbsent() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("3434"), is(user));
    }

    @Test
    @DisplayName("Test addUser when user already exists")
    public void addUserWhenUserAlreadyExists() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        User newUser = new User("3434", "Ivan Ivanov");
        assertThat(bank.findByPassport("3434").getUsername(), is("Petr Petrov"));
    }

    @Test
    @DisplayName("Test findByRequisite when invalid passport")
    public void findByRequisiteWhenEnterInvalidPassport() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByRequisite("34", "5546"));
    }

    @Test
    @DisplayName("Test findByPassport when invalid passport")
    public void findByPassportWhenEnterInvalidPassport() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertNull(bank.findByPassport("5546"));
    }

    @Test
    @DisplayName("Test addAccount")
    public void addAccount() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        assertThat(bank.findByRequisite("3434", "5546").getBalance(), is(150D));
    }

    @Test
    @DisplayName("Test transferMoney. Check balance of destination account")
    public void transferMoneyWhenCheckDestBalance() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 150D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").getBalance(), is(200D));
    }

    @Test
    @DisplayName("Test transferMoney. Check balance of source account")
    public void transferMoneyWhenCheckSrcBalance() {
        User srcUser = new User("3434", "Petr Petrov");
        User destUser = new User("0001", "Ivan Ivanov");
        BankService bank = new BankService();
        bank.addUser(srcUser);
        bank.addUser(destUser);
        bank.addAccount(srcUser.getPassport(), new Account("5546", 150D));
        bank.addAccount(destUser.getPassport(), new Account("113", 50D));
        bank.transferMoney(srcUser.getPassport(), "5546", destUser.getPassport(), "113", 50D);
        assertThat(bank.findByRequisite(srcUser.getPassport(), "5546").getBalance(), is(100D));
    }

    @Test
    @DisplayName("Test transferMoney when insufficient funds")
    public void transferMoneyWhenInsufficientFunds() {
        User user = new User("3434", "Petr Petrov");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 20D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        assertFalse(bank.transferMoney(user.getPassport(), "5546", user.getPassport(), "113", 50D));
    }
}