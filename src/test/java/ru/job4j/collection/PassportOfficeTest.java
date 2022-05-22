package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportOfficeTest {

    @Test
    @DisplayName("Test add method when user is not found, then result = true")
    public void testAddWhenUserIsNotFoundThenTrue() {
        Citizen citizen = new Citizen("2f44a", "Petr Petrov");
        PassportOffice office = new PassportOffice();
        assertTrue(office.add(citizen));
    }

    @Test
    @DisplayName("Test add method when user is found, then result = false")
    public void testAddWhenUserIsFoundThenFalse() {
        Citizen first = new Citizen("2f44a", "Petr Petrov");
        Citizen second = new Citizen("2f44a", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(first);
        assertFalse(office.add(second));
    }
}