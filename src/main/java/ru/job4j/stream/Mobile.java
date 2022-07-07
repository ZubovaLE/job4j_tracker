package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Mobile {
    private final Type type;
    private int price;

    public Mobile(Type type, int price) {
        this.type = type;
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Mobile first = new Mobile(Type.APPLE, 30000);
        Mobile second = new Mobile(Type.APPLE, 35000);
        Mobile third = new Mobile(Type.SAMSUNG, 32000);
        Mobile fourth = new Mobile(Type.SAMSUNG, 27800);
        Mobile fifth = new Mobile(Type.APPLE, 43900);
        Mobile sixth = new Mobile(Type.HUAWEI, 20000);
        Mobile seventh = new Mobile(Type.HUAWEI, 22000);
        List<Mobile> list = new ArrayList<>();
        list.add(fifth);
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(sixth);
        list.add(seventh);

        System.out.print("Count of phones with APPLE type is: ");
        System.out.println((long) list.stream()
                .collect(Collectors.groupingBy(Mobile::getType))
                .get(Type.APPLE)
                .size());

        System.out.print("Sum of prices of SAMSUNG phones is: ");
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Mobile::getType))
                .get(Type.SAMSUNG)
                .stream()
                .map(Mobile::getPrice)
                .reduce(Integer::sum).orElse(0));

        System.out.print("Max price of phones with HUAWEI type is: ");
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Mobile::getType))
                .get(Type.HUAWEI)
                .stream()
                .max(Comparator.comparingInt(Mobile::getPrice)).orElse(null));
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }

    public enum Type {
        SAMSUNG, APPLE, HUAWEI
    }
}
