package ru.job4j.inheritance;

public class Profession {

    private final String name;
    private final String surname;
    private final String education;
    private final int birthday;

    public Profession(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public int getBirthday() {
        return birthday;
    }
}
