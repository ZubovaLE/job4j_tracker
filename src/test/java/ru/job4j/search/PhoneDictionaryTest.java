package ru.job4j.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    @DisplayName("Test find when key is Petr")
    public void findWhenKeyIsPetr() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Petrov", "534872", "Moscow"));
        var persons = phones.find("Petr");
        assertEquals("Petrov", persons.get(0).getSurname());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Ivan:Ivanov:12345:Russia, Moscow:Petr:Petrov:54321:Russia, Samara",
            "Petr:Petrov:54321:Russia, Samara:Ivan:Ivanov:12345:Russia, Moscow"
    }, delimiter = ':')
    @DisplayName("Test find when key is Russia")
    void findWhenKeyIsRussia(String nameOne, String surnameOne, String phoneOne, String addressOne,
                             String nameTwo, String surnameTwo, String phoneTwo, String addressTwo) {
        var phones = new PhoneDictionary();
        var one = new Person(nameOne, surnameOne, phoneOne, addressOne);
        phones.add(one);
        var two = new Person(nameTwo, surnameTwo, phoneTwo, addressTwo);
        phones.add(two);
        var persons = phones.find("Russia");
        assertThat(persons, hasItem(two));
    }

    @Test
    @DisplayName("Test find when key is 12345")
    void findWhenKeyIs12345() {
        var phones = new PhoneDictionary();
        var ivan = new Person("Ivan", "Ivanov", "12345", "Russia, Moscow");
        var petr = new Person("Petr", "Petrov", "54321", "Russia, Samara");
        phones.add(ivan);
        phones.add(petr);
        var persons = phones.find("12345");
        assertEquals(ivan, persons.get(0));
    }

    @Test
    @DisplayName("Test find when key is Ru")
    void findWhenKeyIsRu() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        phones.add(new Person("Petr", "Petrov", "54321", "Russia, Samara"));
        var persons = phones.find("Ru");
        assertEquals(2, persons.size());
    }

    @Test
    @DisplayName("Test find when nobody is found then empty ArrayList")
    void findWhenNotFoundThenEmptyArrayList() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        ArrayList<Person> result = phones.find("Samara");
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test find when key is null then exception")
    void findWhenNull() throws NullPointerException {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Ivan", "Ivanov", "12345", "Russia, Moscow"));
        assertThrows(NullPointerException.class, () -> phones.find(""));
    }
}