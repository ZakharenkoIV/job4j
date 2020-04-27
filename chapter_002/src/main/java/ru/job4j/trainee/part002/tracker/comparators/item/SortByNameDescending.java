package ru.job4j.trainee.part002.tracker.comparators.item;

import ru.job4j.trainee.part002.tracker.Item;

import java.util.Comparator;

public class SortByNameDescending implements Comparator<Item> {


    @Override
    public int compare(Item item, Item t1) {
        return t1.compareTo(item);
    }
}
