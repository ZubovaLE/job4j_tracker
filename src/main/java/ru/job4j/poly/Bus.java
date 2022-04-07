package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("The bus is going");
    }

    @Override
    public void getPassengers(int passengers) {
        System.out.println("The number of sold tickets is " + passengers);
    }

    @Override
    public float refuel(float fuel) {
        if (fuel != 0.0f) {
            return fuel * 94.5f;
        }
        return 0;
    }
}
