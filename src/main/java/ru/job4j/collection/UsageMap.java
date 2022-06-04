package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> data = new HashMap<>();
        data.put("mailbox@mail.com", "Ivanov Ivan Ivanovich");
        data.put("qwerty89@yandex.ru", "Kuznetsov P.V.");
        data.put("qwerty89@yandex.ru", "Kuznetsov Petr Vasilyevich");
        for (String key : data.keySet()) {
            System.out.println(data.get(key));
        }
    }
}
