package ru.job4j.oop;

public class Student {
    public void music() {
        System.out.println("Tra-la-la");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.song();
        petya.music();
        petya.song();
        petya.music();
        petya.song();
    }
}
