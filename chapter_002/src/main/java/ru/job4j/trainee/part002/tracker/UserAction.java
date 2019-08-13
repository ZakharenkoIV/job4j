package ru.job4j.trainee.part002.tracker;

public interface UserAction {
    int key();

    void execute(Input input, Tracker tracker);

    String info();
}
