package ru.job4j.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    @DisplayName("Test find when key is Petr")
    public void findWhenKeyIsPetr() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Petrov", "534872", "Moscow"));
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals("Petrov", persons.get(0).getSurname());
    }

    @Test
    @DisplayName("Test find when key is Russia")
    void findWhenKeyIsRussia() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        phones.add(new Person("Petr", "Petrov", "54321", "Russia, Samara"));
        ArrayList<Person> persons = phones.find("Russia");
        assertEquals("Petr", persons.get(1).getName());
    }

    @Test
    @DisplayName("Test find when key is Samara")
    void findWhenKeyIsSamara() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        phones.add(new Person("Petr", "Petrov", "54321", "Russia, Samara"));
        ArrayList<Person> persons = phones.find("Samara");
        assertEquals("Petr", persons.get(0).getName());
    }

    @Test
    @DisplayName("Test find when key is 12345")
    void findWhenKeyIs12345() {
        PhoneDictionary phones = new PhoneDictionary();
        Person ivan = new Person("Ivan", "Ivanov", "12345", "Russia, Moscow");
        Person petr = new Person("Petr", "Petrov", "54321", "Russia, Samara");
        phones.add(ivan);
        phones.add(petr);
        ArrayList<Person> persons = phones.find("12345");
        assertEquals(ivan, persons.get(0));
    }

    @Test
    @DisplayName("Test find when key is Ru")
    void findWhenKeyIsRu() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        phones.add(new Person("Petr", "Petrov", "54321", "Russia, Samara"));
        ArrayList<Person> persons = phones.find("Ru");
        assertEquals(2, persons.size());
    }

    @Test
    @DisplayName("Test find when not found then empty ArrayList")
    void findWhenNotFoundThenEmptyArrayList() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        ArrayList<Person> result = phones.find("Samara");
        assertTrue(result.isEmpty());
    }
}