package ru.job4j.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AttachmentTest {
    Attachment in = new Attachment("image", 100);

    @Test
    @DisplayName("Test toString")
    void testToString() {
        String expected = "Attachment{name='image', size=100}";
        assertThat(expected, is(in.toString()));
    }

    @Test
    @DisplayName("Test getName when name is image")
    void getName() {
        String expectedName = "image";
        assertThat(expectedName, is(in.getName()));
    }

    @Test
    @DisplayName("Test getSize when size = 100")
    void getSize() {
        int expectedSize = 100;
        assertThat(expectedSize, is(in.getSize()));
    }
}