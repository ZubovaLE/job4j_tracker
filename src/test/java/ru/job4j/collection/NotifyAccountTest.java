package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("Test sent method when duplicates")
    public void testSentWhenDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Petrov", "eDer3432f"),
                new Account("142", "Petr Petrov", "000001"),
                new Account("123", "Petr Petrov", "eDer3432f"),
                new Account("142", "Petr Petrov", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Petrov", "eDer3432f"),
                        new Account("142", "Petr Petrov", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}