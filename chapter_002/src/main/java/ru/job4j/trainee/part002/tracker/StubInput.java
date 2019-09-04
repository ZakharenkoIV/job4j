package ru.job4j.trainee.part002.tracker;

//Наследование
public class StubInput extends ConsoleInput {
    private final String[] answers;
    private int position = 0;
    //Агрегация
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        System.out.println(question);
        return answers[position++];
    }
}
