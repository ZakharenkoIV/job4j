package ru.job4j.trainee.part002.tracker;

import java.util.ArrayList;
import java.util.List;

class Tracker {
    private ArrayList<Item> listItems = new ArrayList<>();
    private boolean exitProgram = true;

    public boolean getExitProgram() {
        return exitProgram;
    }

    public void setExitProgram(boolean exitProgram) {
        this.exitProgram = exitProgram;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        listItems.add(item);
        return item;
    }

    private String generateId() {
        return Long.toString(System.nanoTime());
    }

    public boolean replace(String id, Item item) {
        boolean success = false;
        for (int index = 0; index < listItems.size(); index++) {
            if (listItems.get(index).getId().equals(id)) {
                item.setId(id);
                listItems.set(index, item);
                success = true;
                break;
            }
        }
        return success;
    }

    public boolean delete(String id) {
        boolean success = false;
        for (int index = 0; index < listItems.size(); index++) {
            if (listItems.get(index).getId().equals(id)) {
                listItems.remove(index);
            }
        }
        return success;
    }

    public ArrayList<Item> findAll() {
        return listItems;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : listItems) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : listItems) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }
}

