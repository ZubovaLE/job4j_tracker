package ru.job4j.ex;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStoreTest {

    @Test
    @DisplayName("Test findUser method when user is not found then exception")
    void findUserWhenUserIsNotFound() {
        User[] input = new User[]{
                new User("Petr", true),
                new User("Mark", true)
        };
        String login = "John";
        Assert.assertThrows(UserNotFoundException.class, () -> UserStore.findUser(input, login));
    }

    @Test
    @DisplayName("Test findUser when user is found")
    void findUserWhenLoginIsMark() throws UserNotFoundException {
        User first = new User("Petr", true);
        User second = new User("Mark", true);
        User third = new User("Alex", true);
        User[] input = new User[]{first, second, third};
        String login = "Mark";
        User out = UserStore.findUser(input, login);
        assertEquals(second, out);
    }

    @Test
    @DisplayName("Test validate method when user's valid is false then exception")
    void testValidateWhenValidIsFalseThenException() {
        User in = new User("Petr", false);
        Assert.assertThrows(UserInvalidException.class, () -> UserStore.validate(in));
    }

    @Test
    @DisplayName("Test validate method when user's name length is less than 3 then exception")
    void testValidateWhenNameLengthIsLessThen3ThenException() {
        User in = new User("A", true);
        Assert.assertThrows(UserInvalidException.class, () -> UserStore.validate(in));
    }

    @Test
    @DisplayName("Test validate method when both requirements are violated then exception")
    void testValidateWhenBothRequirementsAreViolatedThenException() {
        User in = new User("A", false);
        Assert.assertThrows(UserInvalidException.class, () -> UserStore.validate(in));
    }

    @Test
    @DisplayName("Test validate method when proper input data")
    void validateWhenProperInputData() throws UserInvalidException {
        User input = new User("Petr", true);
        boolean out = UserStore.validate(input);
        assertTrue(out);
    }
}