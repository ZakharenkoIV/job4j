package ru.job4j.trainee.part002.tracker;

public interface Input {
    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
