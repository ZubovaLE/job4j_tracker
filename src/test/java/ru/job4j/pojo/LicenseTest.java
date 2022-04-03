package ru.job4j.pojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseTest {

    @Test
    @DisplayName("Test the equals method when names are equal")
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test the equals method when owners are equal")
    public void eqOwner() {
        License first = new License();
        first.setOwner("Ivanov");
        License second = new License();
        second.setOwner("Ivanov");
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test the equals method when models are equal")
    public void eqModel() {
        License first = new License();
        first.setModel("multi");
        License second = new License();
        second.setModel("multi");
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test the equals method when created are equal")
    public void eqCreated() {
        Date date = new Date();
        License first = new License();
        first.setCreated(date);
        License second = new License();
        second.setCreated(date);
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test the equals method when objects are not equal")
    public void whenNotEqual() {
        License first = new License();
        first.setOwner("Petrov");
        License second = new License();
        second.setOwner("Ivanov");
        boolean expected = first.equals(second);
        assertFalse(expected);
    }
}