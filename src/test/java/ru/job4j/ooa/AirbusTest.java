package ru.job4j.ooa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirbusTest {

    @Test
    @DisplayName("Test getName when name = A320")
    void getName() {
        Output output = new StubOutput();
        Airbus airbus = new Airbus("A320", output);
        String out = airbus.getName();
        String expected = "A320";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test setName when new name = A400")
    void setName() {
        Output output = new StubOutput();
        Airbus airbus = new Airbus("A320", output);
        airbus.setName("A400");
        String expected = "A400";
        assertEquals(expected, airbus.getName());
    }

    @Test
    @DisplayName("Test toString override")
    void testToString() {
        Output output = new StubOutput();
        Airbus airbus = new Airbus("A320", output);
        String expected = "Airbus{name='A320'}";
        assertEquals(expected, airbus.toString());
    }

    @Test
    @DisplayName("Test printModel")
    void testPrintModel() {
        Output output = new StubOutput();
        Airbus airbus = new Airbus("A320", output);
        airbus.printModel();
        String expected = "Модель самолета: " + airbus.getName();
        assertEquals(expected, output.toString());
    }

    @Test
    @DisplayName("Test printCountEngine when A320")
    void testPrintCountEngine() {
        Output output = new StubOutput();
        Airbus airbus = new Airbus("A320", output);
        airbus.printCountEngine();
        String expected = "Количество двигателей равно: 2";
        assertEquals(expected, output.toString());
    }

    @Test
    @DisplayName("Test printCountEngine when A380")
    void testPrintCountEngineWhenA380() {
        Output output = new StubOutput();
        Airbus airbus = new Airbus("A380", output);
        airbus.printCountEngine();
        String expected = "Количество двигателей равно: 4";
        assertEquals(expected, output.toString());
    }
}