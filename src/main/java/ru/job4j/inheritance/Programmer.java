package ru.job4j.inheritance;

public class Programmer extends Engineer{

    private final String language;

    public Programmer(String name, String surname, String education, int birthday, int experience, String language) {
        super(name, surname, education, birthday, experience);
        this.language = language;
    }

    public void writeProgram() {
        System.out.println("This is my program");
    }
}
