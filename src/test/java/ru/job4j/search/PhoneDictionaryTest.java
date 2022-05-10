package ru.job4j.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    void add() {
    }

    @Test
    @DisplayName("Test find when key is Petr")
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    @DisplayName("Test find when key is Russia")
    void findWhenKeyIsRussia() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        phones.add(new Person("Petr", "Petrov", "54321", "Russia, Samara"));
        ArrayList<Person> persons = phones.find("Russia");
        assertEquals(persons.get(1).getSurname(), "Petrov");
    }
}