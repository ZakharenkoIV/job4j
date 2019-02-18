package ru.job4j.trainee.part002.tracker;

public class StubInput implements Input {
    private final String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }
}