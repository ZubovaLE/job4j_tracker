package ru.job4j.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AccountTest {

    @Test
    @DisplayName("Test getRequisite")
    void getRequisite() {
        Account account = new Account("11", 100D);
        String out = account.getRequisite();
        String expected = "11";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setRequisite")
    void setRequisite() {
        Account account = new Account("11", 100D);
        account.setRequisite("22");
        String out = account.getRequisite();
        String expected = "22";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test getBalance")
    void getBalance() {
        Account account = new Account("11", 100D);
        double out = account.getBalance();
        double expected = 100D;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setBalance")
    void setBalance() {
        Account account = new Account("11", 100D);
        account.setBalance(200D);
        double out = account.getBalance();
        double expected = 200D;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test equals when objects are equal then true")
    void testEqualsWhenObjectsAreEqual() {
        Account first = new Account("11", 100D);
        Account second = new Account("11", 500D);
        assertThat(first.equals(second), is(true));
    }

    @Test
    @DisplayName("Test equals when objects are not equal then false")
    void testEqualsWhenObjectsAreNotEqual() {
        Account first = new Account("11", 100D);
        Account second = new Account("12", 100D);
        assertThat(first.equals(second), is(false));
    }
}