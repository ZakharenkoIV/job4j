package ru.job4j.trainee.part002.tracker;

public class Item implements Comparable<Item> {
    private String id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n" + "Имя заявки: " + getName() + "\n";
    }

    @Override
    public int compareTo(Item item) {
        return name.compareTo(item.name);
    }
}
