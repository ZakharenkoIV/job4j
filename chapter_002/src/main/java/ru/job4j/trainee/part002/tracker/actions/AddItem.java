package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Tracker;

public class AddItem implements UserAction {
    @Override
    public String name() {
        return "Добавление новой заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки : ");
        Item item = new Item(name);
        tracker.add(item);
        if (tracker.findById(item.getId()) == null) {
            System.out.println("Заявка добавлена");
        } else {
            System.out.println("Заявка не добавлена");
        }
        return true;
    }
}
