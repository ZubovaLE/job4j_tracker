package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class NotifyAccountTest {

    @Test
    @DisplayName("Test sent method when no duplicates")
    public void testSentWhenDuplicates() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    @DisplayName("Test sent method when empty")
    public void testSentWhenEmpty() {
        List<Account> in = new ArrayList<>();
        HashSet<Account> out = NotifyAccount.sent(in);
        assertThat(out, is(empty()));
    }

    @Test
    @DisplayName("Test sent method when one account then size = 1")
    public void testSentWhenOneAccount() {
        List<Account> in = List.of(new Account("123", "Petr Arsentev", "eDer3432f"));
        HashSet<Account> out = NotifyAccount.sent(in);
        assertThat(out, hasSize(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"123, Petr Petrov, eder3432f, 142, Ivan Ivanov, 000001, 123, Petr Petrov, eder3432f",
            "123, Petr Petrov, eder3432f, 142, Ivan Ivanov, 000001, 142, Ivan, 000001"
    })
    @DisplayName("Test sent method when duplicates")
    void test(String passportOne, String usernameOne, String depositOne,
              String passportTwo, String usernameTwo, String depositTwo,
              String passportThree, String usernameThree, String depositThree
    ) {
        Account one = new Account(passportOne, usernameOne, depositOne);
        Account two = new Account(passportTwo, usernameTwo, depositTwo);
        Account three = new Account(passportThree, usernameThree, depositThree);
        List<Account> accounts = Arrays.asList(one, two, three);
        HashSet<Account> expect = new HashSet<>(Arrays.asList(one, two));
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}