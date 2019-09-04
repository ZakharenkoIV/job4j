package ru.job4j.trainee.part002.tracker;

//Наследование
public class MenuOutException extends RuntimeException {
    public MenuOutException(String messageException) {
        super(messageException);
    }
}
