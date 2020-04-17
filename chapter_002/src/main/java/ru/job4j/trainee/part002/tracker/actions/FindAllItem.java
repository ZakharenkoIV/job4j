package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Tracker;

import java.util.List;

public class FindAllItem implements UserAction {
    @Override
    public String name() {
        return "Все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> itemList = tracker.findAll();
        if (itemList.size() != 0) {
            for (Item item : tracker.findAll()) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявок не найдено");
        }
        return true;
    }
}
