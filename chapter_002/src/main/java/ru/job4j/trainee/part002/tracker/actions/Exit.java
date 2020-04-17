package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Tracker;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
