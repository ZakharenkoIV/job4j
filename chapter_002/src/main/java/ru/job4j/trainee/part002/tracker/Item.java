package ru.job4j.trainee.part002.tracker;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "items")
public class Item implements Comparable<Item> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private final Timestamp created;

    public Item() {
        created = new Timestamp(System.currentTimeMillis());
    }

    public Item(String name) {
        this.name = name;
        created = new Timestamp(System.currentTimeMillis());
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        created = new Timestamp(System.currentTimeMillis());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
