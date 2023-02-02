package ru.job4j.tracker;


import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int sizeNew = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name != null) {
                rsl[sizeNew] = name;
                sizeNew++;
            }
        }
        return Arrays.copyOf(rsl, sizeNew);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizeNew = 0;
        for (int index = 0; index < size; index++) {
            Item name = items[index];
            if (name.getName().equals(key)) {
                rsl[sizeNew] = name;
                sizeNew++;
            }
        }
        return Arrays.copyOf(rsl, sizeNew);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            return true;
        }
        return false;
    }
}