package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Tracker;

public class FindByNameItem implements UserAction {
    @Override
    public String name() {
        return "Поиск заявок по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки : ");
        boolean itemCheck = false;
        for (Item item : tracker.findAll()) {
            if (item.getName().equals(name)) {
                System.out.println(item);
                itemCheck = true;
            }
        }
        if (!itemCheck) {
            System.out.println("Заявок с таким именем не найдено");
        }
        return true;
    }
}
