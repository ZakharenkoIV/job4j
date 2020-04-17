package ru.job4j.trainee.part002.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private List<Item> itemList = new ArrayList<>();

    public Item add(Item item) {
        item.setId(this.generateId());
        itemList.add(item);
        return item;
    }

    private String generateId() {
        return String.valueOf(new Random().nextLong() + System.currentTimeMillis());
    }

    public List<Item> findAll() {
        return itemList;
    }

    public List<Item> findByName(String name) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : itemList) {
            if (item.getName().equals(name)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public Item findById(String id) {
        Item foundItem = null;
        for (Item item : itemList) {
            if (item.getId().equals(id)) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }

    public boolean replace(String id, Item item) {
        item.setId(id);
        int index = itemList.indexOf(this.findById(id));
        itemList.remove(index);
        itemList.add(index, item);
        return true;
    }

    public boolean delete(String id) {
        itemList.remove(this.findById(id));
        return true;
    }
}
