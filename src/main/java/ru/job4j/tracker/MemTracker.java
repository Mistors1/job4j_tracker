package ru.job4j.tracker;



import java.util.ArrayList;
import java.util.List;

public class MemTracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>(size);
        int sizeNew = 0;
        for (int index = 0; index < size; index++) {
            Item name = items.get(index);
            if (name != null) {
                rsl.add(sizeNew, name);
                sizeNew++;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>(size);
        int sizeNew = 0;
        for (int index = 0; index < size; index++) {
            Item name = items.get(index);
            if (name.getName().equals(key)) {
                rsl.add(sizeNew, name);
                sizeNew++;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.add(index, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(size - 1);
            size--;
            return true;
        }
        return false;
    }
}