package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Store;

import java.sql.SQLException;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "Редактирование заявки";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
            int id = input.askInt("Введите ID заявки : ");
        try {
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка с таким ID не найдена");
            } else {
                String name = input.askStr("Введите имя заявки : ");
                item.setName(name);
                boolean replaceSuccess = tracker.replace(id, item);
                if (replaceSuccess) {
                    System.out.println("Заявка отредактирована");
                } else {
                    System.out.println("Заявка не отредактирована");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

