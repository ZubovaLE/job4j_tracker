package ru.job4j.pojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseTest {

    @Test
    @DisplayName("Test equals method when names are equal")
    void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test equals method when owners are equal")
    void eqOwner() {
        License first = new License();
        first.setOwner("Ivanov");
        License second = new License();
        second.setOwner("Ivanov");
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test equals method when models are equal")
    void eqModel() {
        License first = new License();
        first.setModel("multi");
        License second = new License();
        second.setModel("multi");
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test equals method when created are equal")
    void eqCreated() {
        Date date = new Date();
        License first = new License();
        first.setCreated(date);
        License second = new License();
        second.setCreated(date);
        boolean expected = first.equals(second);
        assertTrue(expected);
    }

    @Test
    @DisplayName("Test equals method when objects are not equal")
    void whenNotEqual() {
        License first = new License();
        first.setOwner("Petrov");
        License second = new License();
        second.setOwner("Ivanov");
        boolean expected = first.equals(second);
        assertFalse(expected);
    }

    @Test
    @DisplayName("Test getModel when model is multi")
    void testGetModelWhenModelIsMulti() {
        License license = new License();
        license.setModel("multi");
        String out = license.getModel();
        String expected = "multi";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test getOwner when owner is Petrov")
    void testGetOwnerWhenOwnerIsPetrov() {
        License license = new License();
        license.setOwner("Petrov");
        String out = license.getOwner();
        String expected = "Petrov";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test getCode when code is audio")
    void testGetCodeWhenCodeIsMulti() {
        License license = new License();
        license.setCode("audio");
        String out = license.getCode();
        String expected = "audio";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test getCreated when created is date")
    void testGetCreatedWhenCodeIsMulti() {
        License license = new License();
        Date date = new Date();
        license.setCreated(date);
        Date out = license.getCreated();
        assertEquals(date, out);
    }
}