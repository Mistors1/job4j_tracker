package ru.job4j.collection;

import java.util.HashMap;
public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("IDM@mail.ru", "MyName");
        mail.put("IDMf@mail.ru", "MyNhame");
        mail.put("IhfDM@mail.ru", "MyNassme");
        mail.put("IDMsg@mail.ru", "MyNa6me");
        for (String key : mail.keySet()) {
            String value = mail.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
