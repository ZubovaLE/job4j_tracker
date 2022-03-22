package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private final boolean childish;

    public Dentist(String name, String surname, String education, int birthday, String degree, boolean childish) {
        super(name, surname, education, birthday, degree);
        this.childish = childish;
    }

    public void fixTeeth() {
        System.out.println("I have a patient now");
    }
}
