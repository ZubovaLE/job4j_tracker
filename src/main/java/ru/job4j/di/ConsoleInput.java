package ru.job4j.di;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInput {
    public void printMessage(String message) {
        System.out.println(message);
    }
}