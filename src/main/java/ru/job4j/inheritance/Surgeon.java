package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private final int operations;

    public Surgeon(String name, String surname, String education, int birthday, String degree, int operations) {
        super(name, surname, education, birthday, degree);
        this.operations = operations;
    }

    public int getOperations() {
        return operations;
    }
}
