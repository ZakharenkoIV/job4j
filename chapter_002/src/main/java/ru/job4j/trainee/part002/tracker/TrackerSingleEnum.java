package ru.job4j.trainee.part002.tracker;

import java.util.ArrayList;

public enum TrackerSingleEnum {
    INSTANCE;

    Tracker tracker = new Tracker();

    public boolean getExitProgram() {
        return tracker.getExitProgram();
    }

    public void setExitProgram(boolean exitProgram) {
        tracker.setExitProgram(exitProgram);
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return tracker.delete(id);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public ArrayList<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(String id) {
        return tracker.findById(id);
    }
}

