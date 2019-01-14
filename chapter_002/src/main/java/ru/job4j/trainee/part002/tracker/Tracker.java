package ru.job4j.trainee.part002.tracker;

import java.util.Arrays;

public class Tracker {
    private Item[] items = new Item[100];

    public Item add(Item item) {
        item.setId(this.generateId());
        if (items[items.length - 1] != null) {
            items = Arrays.copyOf(items, items.length + 1);
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
        return item;
    }

    private String generateId() {
        return Long.toString(System.nanoTime());
    }

    public boolean replace(String id, Item item) {
        boolean success = false;
        for (int index = 0; index < items.length; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = item;
                success = true;
                break;
            }
        }
        return success;
    }

    public boolean delete(String id) {
        boolean success = false;
        items = findAll();
        Item[] it = items;
        for (int index = 0; index < items.length; index++) {
            if (items[index].getId().equals(id)) {
                items[index] = null;
                success = true;
                System.arraycopy(items, index + 1, it, index, items.length - 1 - index);
                items = Arrays.copyOf(it, it.length - 1);
                break;
            }
        }
        return success;
    }

    public Item[] findAll() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items = Arrays.copyOf(items, i);
            }
        }
        return items;
    }

    public Item[] findByName(String key) {
        Item[] item = new Item[items.length];
        int identicalNames = 0;
        for (Item item1 : items) {
            if (item1 != null && item1.getName().equals(key)) {
                item[identicalNames++] = item1;
            }
        }
        item = Arrays.copyOf(item, identicalNames);
        return item;
    }

    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < findAll().length; i++) {
            if (items[i].getId().equals(id)) {
                item = items[i];
                break;
            }
        }
        return item;
    }
}

