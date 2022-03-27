package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student first = new Student();
        first.setFullName("Ivanov Petr");
        first.setGroup("S17-103");
        first.setDateOfEnter(2017);
        System.out.println(first.getFullName() + " is from " + first.getGroup() + ". Date of enter to the University is " + first.getDateOfEnter());
    }
}
