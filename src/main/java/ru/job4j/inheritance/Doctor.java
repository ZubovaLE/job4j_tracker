package ru.job4j.inheritance;

public class Doctor extends Profession{

    private final String degree;

    public Doctor(String name, String surname, String education, int birthday, String degree) {
        super(name, surname, education, birthday);
        this.degree = degree;
    }

    public void treat() {
        System.out.println("I am treating");
    }

}
