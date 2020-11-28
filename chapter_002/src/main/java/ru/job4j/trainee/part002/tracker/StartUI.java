package ru.job4j.trainee.part002.tracker;


import ru.job4j.trainee.part002.tracker.actions.*;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public void init(Input input, Store tracker, List<UserAction> userActions) {
        boolean run = true;
        while (run) {
            this.showMenu(userActions);
            int select = input.askInt("Введите пункт меню : ");
            UserAction userAction = userActions.get(select);
            run = userAction.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> userActions) {
        System.out.println("Меню:");
        for (UserAction userAction : userActions) {
            System.out.println(userActions.indexOf(userAction) + ". " + userAction.name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput(new ConsoleInput());
        List<UserAction> userAction = new ArrayList<>();
        userAction.add(new AddItem());
        userAction.add(new DeleteItem());
        userAction.add(new FindAllItem());
        userAction.add(new FindByIdItem());
        userAction.add(new FindByNameItem());
        userAction.add(new ReplaceItem());
        userAction.add(new Exit());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            new StartUI().init(validate, tracker, userAction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
