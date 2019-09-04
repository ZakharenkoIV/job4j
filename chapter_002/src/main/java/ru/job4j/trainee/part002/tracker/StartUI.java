package ru.job4j.trainee.part002.tracker;

public class StartUI {

    //Агрегация
    private final Tracker tracker;
    private final Input input;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        //Композиция
        MenuTracker menu = new MenuTracker(this.tracker, this.input);
        menu.fillAction();
        while (tracker.getExitProgram()) {
            menu.show();
            menu.select(input.ask("Ввеедите пункт меню : ", menu.rangeMenu()));
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
