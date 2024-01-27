package ru.job4j.integration.orders;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String description;

    private Timestamp created;

    public static Order of(String name, String description) {
        Order o = new Order();
        o.name = name;
        o.description = description;
        o.created = new Timestamp(System.currentTimeMillis());
        return o;
    }

    public void setId(int id) {
        this.id = id;
    }
}