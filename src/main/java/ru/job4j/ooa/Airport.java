package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Airbus airbus = new Airbus("A320", out);
        out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

        airbus = new Airbus("A380", out);
        out.println(airbus);
        airbus.printModel();
        airbus.printCountEngine();

        airbus.setName("A380");
        out.println(airbus);
    }
}
