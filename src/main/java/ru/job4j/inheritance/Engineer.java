package ru.job4j.inheritance;

public class Engineer extends Profession {

    private final int experience;

    public Engineer(String name, String surname, String education, int birthday, int experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }
}
