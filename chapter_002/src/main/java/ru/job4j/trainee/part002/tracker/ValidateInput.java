package ru.job4j.trainee.part002.tracker;

import java.util.Scanner;

public class ValidateInput extends ConsoleInput {

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException | NumberFormatException exc) {
                System.out.println("Такого пункта не существует.");
            }
        } while (invalid);
        return value;
    }
}
