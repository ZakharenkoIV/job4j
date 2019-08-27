package ru.job4j.trainee.part002.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
