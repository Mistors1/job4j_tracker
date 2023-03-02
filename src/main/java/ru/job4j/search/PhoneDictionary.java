package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.*;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = k -> k.getName().contains(key);
        Predicate<Person> predPhone = k -> k.getPhone().contains(key);
        Predicate<Person> predSurname = k -> k.getSurname().contains(key);
        Predicate<Person> predAddress = k -> k.getAddress().contains(key);

        Predicate<Person> combine = k -> predName.or(predPhone).or(predSurname).or(predAddress).test(k);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
