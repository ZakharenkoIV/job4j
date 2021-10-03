package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Store;

import java.sql.SQLException;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Введите ID заявки : ");
        Item item;
        try {
            item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка с таким ID не найдена");
            } else {
                tracker.delete(id);
                if (tracker.findById(id) != null) {
                    System.out.println("Заявка не удалена");
                } else {
                    System.out.println("Заявка удалена");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
