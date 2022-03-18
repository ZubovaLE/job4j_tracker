package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {

    @Test
    @DisplayName("Test getLoad when this.load = 30, another.load = 50, then another.load = 80")
    public void whenThis30Another50ThenAnotherLoadEqual80() {
        Battery charger = new Battery(30);
        Battery another = new Battery(50);
        charger.exchange(another);
        int expected = 80;
        assertEquals(expected, another.getLoad());
    }

    @Test
    @DisplayName("Test getLoad when this.load = 80, another.load = 20, then this.load = 0")
    public void whenThis80Another20ThenThisLoadEqual0() {
        Battery charger = new Battery(80);
        Battery another = new Battery(20);
        charger.exchange(another);
        int expected = 0;
        assertEquals(expected, charger.getLoad());
    }

    @Test
    @DisplayName("Test getLoad when this.load = 95, another.load = 0, then another.load = 95")
    public void whenThis95Another0ThenAnotherLoadEqual80() {
        Battery charger = new Battery(95);
        Battery another = new Battery(0);
        charger.exchange(another);
        int expected = 95;
        assertEquals(expected, another.getLoad());
    }

    @Test
    @DisplayName("Test getLoad when this.load = 0, another.load = 50, then another.load = 50")
    public void whenThis0Another50ThenAnotherLoadEqua50() {
        Battery charger = new Battery(0);
        Battery another = new Battery(50);
        charger.exchange(another);
        int expected = 50;
        assertEquals(expected, another.getLoad());
    }

    @Test
    @DisplayName("Test getLoad when this.load = 0, another.load = 0, then another.load = 0")
    public void whenThis0Another0ThenAnotherLoadEqual0() {
        Battery charger = new Battery(0);
        Battery another = new Battery(0);
        charger.exchange(another);
        int expected = 0;
        assertEquals(expected, another.getLoad());
    }
}