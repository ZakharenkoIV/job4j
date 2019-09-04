package ru.job4j.trainee.part002.tracker;
//Композиция
public class ValidateInput implements Input {
    private final Input input;
    //Агрегация
    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException exc) {
                System.out.println("Такого пункта не существует.");
            } catch (NumberFormatException exc) {
                System.out.println("Введите номер пункта меню");
            }
        } while (invalid);
        return value;
    }
}
