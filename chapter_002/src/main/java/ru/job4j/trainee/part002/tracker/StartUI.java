package ru.job4j.trainee.part002.tracker;

public class StartUI {

    private final Tracker tracker;
    private final Input input;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.tracker, this.input);
        menu.fillAction();
        while (tracker.getExitProgram()) {
            menu.show();
            menu.select(input.ask("Ввеедите пункт меню : ", menu.rangeMenu()));
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
