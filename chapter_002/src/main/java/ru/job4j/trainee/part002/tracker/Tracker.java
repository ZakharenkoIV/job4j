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
        listItems.remove(this.findById(id));
        item.setId(id);
        listItems.add(item);
        if (this.findById(id).equals(item)) {
            success = true;
            System.out.println("------------ Заявка отредактирована ------------");
        } else {
            System.out.println("------------ Заявка не отредактирована ------------");
        }
        return success;
    }

    public boolean delete(String id) {
        boolean success = false;
        Item item = this.findById(id);
        if (item != null) {
            listItems.remove(item);
            if (this.findById(id) != item) {
                success = true;
                System.out.println("------------ Заявка удалена ------------");
            } else {
                System.out.println("------------ Заявка не удалена ------------");
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
        if (result == null) {
            System.out.println("------------ Заявка не найдена ------------");
        }
        return result;
    }
}

