package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Lubovj99@yandex.com", "Nikiforova Lyubov");
        map.put("Lubovj99@mail.ru", "Nikiforova Lyubov Evgenievna");
        for (String user : map.keySet()) {
            System.out.println("User with email " + user + " is " + map.get(user));
        }
    }
}
