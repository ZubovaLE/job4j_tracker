package ru.job4j.inheritance;

public class Builder extends Engineer {

    private final int wages;

    public Builder(String name, String surname, String education, int birthday, int experience, int wages) {
        super(name, surname, education, birthday, experience);
        this.wages = wages;
    }

    public void build() {
        System.out.println("I am building");
    }
}
