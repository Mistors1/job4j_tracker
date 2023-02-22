package ru.job4j.collection;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class NotifyAccount {
    public static Set<Account> sent(List<Account> accounts) {
        return new HashSet<>(accounts);
    }
}
