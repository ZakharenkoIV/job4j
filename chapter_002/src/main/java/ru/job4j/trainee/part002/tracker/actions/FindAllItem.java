package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.Store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindAllItem implements UserAction {
    @Override
    public String name() {
        return "Все заявки";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        try {
            ArrayList<Integer[]> list = new ArrayList();
            while (true) {
                Integer[] o = new Integer[100];
                for (int i = 0; i < 100; i++) {
                    o[i] = i;
                }
                list.add(o);

                List<Item> itemList = tracker.findAll();
                if (itemList.size() != 0) {
                    for (Item item : tracker.findAll()) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявок не найдено");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
