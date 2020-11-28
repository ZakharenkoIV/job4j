package ru.job4j.trainee.part002.tracker.actions;

import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
