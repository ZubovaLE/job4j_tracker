package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ComputerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final String ln = System.lineSeparator();
    private final Computer comp = new Computer(true, 512.0, "AMD Ryzen 7 3700X");

    @Test
    @DisplayName("Test printInfo")
    void printInfo() {
        System.setOut(new PrintStream(outputStreamCaptor));
        comp.printInfo();
        StringBuilder expected = new StringBuilder();
        expected.append("Много мониторов: true").append(ln).append("SSD: 512").append(" GB")
                .append(ln).append("Модель CPU: AMD Ryzen 7 3700X");
        String result = outputStreamCaptor.toString().trim();
        System.setOut(standardOut);
        assertThat(result, is(expected.toString()));
    }

    @Test
    void main() {
        System.setOut(new PrintStream(outputStreamCaptor));
        Computer.main(null);
        StringBuilder expected = new StringBuilder();
        expected.append("Много мониторов: false").append(ln).append("SSD: 0").append(" GB")
                .append(ln).append("Модель CPU: null").append(ln).append(ln)
                .append("Много мониторов: false").append(ln).append("SSD: 256").append(" GB")
                .append(ln).append("Модель CPU: AMD Ryzen 5 3600").append(ln).append(ln)
                .append("Много мониторов: true").append(ln).append("SSD: 500").append(" GB")
                .append(ln).append("Модель CPU: Intel Core I7-10700K").append(ln).append(ln)
                .append("Много мониторов: true").append(ln).append("SSD: 512").append(" GB")
                .append(ln).append("Модель CPU: AMD Ryzen 7 3700X");
        String result = outputStreamCaptor.toString().trim();
        System.setOut(standardOut);
        assertThat(result, is(expected.toString()));
    }
}