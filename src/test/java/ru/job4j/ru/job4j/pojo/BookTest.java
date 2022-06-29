package ru.job4j.ru.job4j.pojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BookTest {
    private final Book scienceFiction = new Book("Space", 345);

    @Test
    @DisplayName("Test getName when name is Space")
    void getName() {
        String out = scienceFiction.getName();
        String expected = "Space";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setName when new name is Aliens")
    void setName() {
        Book aliens = new Book();
        String in = "Aliens";
        aliens.setName(in);
        String out = aliens.getName();
        String expected = "Aliens";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test getPages when pages = 345")
    void getPages() {
        int out = scienceFiction.getPages();
        int expected = 345;
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test setPages when pages = 234")
    void setPages() {
        Book aliens = new Book();
        int in = 234;
        aliens.setPages(in);
        int out = aliens.getPages();
        int expected = 234;
        assertThat(out, is(expected));
    }
}