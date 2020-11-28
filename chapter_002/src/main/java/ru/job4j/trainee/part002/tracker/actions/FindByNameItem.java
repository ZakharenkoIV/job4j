package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Store;

import java.sql.SQLException;

public class FindByNameItem implements UserAction {
    @Override
    public String name() {
        return "Поиск заявок по имени";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Введите имя заявки : ");
        boolean itemCheck = false;
        try {
            for (Item item : tracker.findAll()) {
                if (item.getName().equals(name)) {
                    System.out.println(item);
                    itemCheck = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!itemCheck) {
            System.out.println("Заявок с таким именем не найдено");
        }
        return true;
    }
}
