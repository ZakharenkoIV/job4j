package ru.job4j.trainee.part002.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemTracker implements Store {
    private final List<Item> itemList = new ArrayList<>();

    public Item add(Item item) {
        item.setId(this.generateId());
        itemList.add(item);
        return item;
    }

    private int generateId() {
        return new Random().nextInt() + (int) System.currentTimeMillis();
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

    public Item findById(int id) {
        Item foundItem = null;
        for (Item item : itemList) {
            if (item.getId() == id) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }

    public boolean replace(int id, Item item) {
        item.setId(id);
        int index = itemList.indexOf(this.findById(id));
        itemList.remove(index);
        itemList.add(index, item);
        return true;
    }

    public boolean delete(int id) {
        itemList.remove(this.findById(id));
        return true;
    }

    @Override
    public void close() {
    }
}
