package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Store;

import java.sql.SQLException;

public class FindByIdItem implements UserAction {
    @Override
    public String name() {
        return "Поиск заявки по ID";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Введите ID заявки : ");
        try {
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Заявка с таким ID не найдена");
            } else {
                System.out.println(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
