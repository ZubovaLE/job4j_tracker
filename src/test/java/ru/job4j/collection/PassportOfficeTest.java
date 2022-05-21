package ru.job4j.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassportOfficeTest {

    @Test
    @DisplayName("test add when no user")
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();;
        assertFalse(office.add(citizen));
    }
}