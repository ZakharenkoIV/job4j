package ru.job4j.trainee.part002.tracker;

public interface Input {

    String ask(String question);

    int ask(String question, int[] range);
}
