package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private final Output out;
    private static final int COUNT_ENGINE = 2;
    private static final int COUNT_ENGINE_A380 = 4;
    private String name;

    public Airbus(String name, Output out) {
        this.name = name;
        this.out = out;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        out.println("Количество двигателей равно: " + (!getName().equals("A380") ? COUNT_ENGINE : COUNT_ENGINE_A380));
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
