package ru.job4j.di;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StartUI {
    private final Store store;
    private final ConsoleInput consoleInput;

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        store.getAll().forEach(System.out::println);
    }

    public void printMessage(String message) {
        consoleInput.printMessage(message);
    }

}