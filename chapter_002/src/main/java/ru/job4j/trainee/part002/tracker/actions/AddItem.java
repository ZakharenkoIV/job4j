package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Store;

import java.sql.SQLException;

public class AddItem implements UserAction {
    @Override
    public String name() {
        return "Добавление новой заявки";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Введите имя заявки : ");
        try {
            Item newItem = tracker.add(new Item(name));
            if (tracker.findById(newItem.getId()) != null) {
                System.out.println("Заявка добавлена");
            } else {
                System.out.println("Заявка не добавлена");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
