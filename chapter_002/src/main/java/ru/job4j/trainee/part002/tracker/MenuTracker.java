package ru.job4j.trainee.part002.tracker;

import java.util.Arrays;

public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private UserAction[] action = new UserAction[6];

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    public void fillAction() {
        this.action[0] = new AddItem(this.tracker, this.input);
        this.action[1] = new ShowAllItems(this.tracker, this.input);
        this.action[2] = new EditItems(this.tracker, this.input);
        this.action[3] = new DeleteItems(this.tracker, this.input);
        this.action[4] = new FindById(this.tracker, this.input);
        this.action[5] = new FindByName(this.tracker, this.input);
    }

    public void select(int key) {
        this.action[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.action) {
            System.out.println(action.info());
        }
    }


    private class AddItem implements UserAction {

        public AddItem(Tracker tracker, Input input) {
        }

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки ------------");
            String name = input.ask("Введите имя заявки : ");
            String desc = input.ask("Введите описание заявки : ");
            Item item = new Item(name, desc);
            item = tracker.add(item);
            System.out.println("------------ ID новой заявки : " + item.getId() + "------------");
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавление новой заявки");
        }
    }

    private class ShowAllItems implements UserAction {

        public ShowAllItems(Tracker tracker, Input input) {
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки ------------");
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s", item.getName(), item.getId()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Все заявки");
        }
    }

    private class EditItems implements UserAction {

        public EditItems(Tracker tracker, Input input) {
        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки ------------");
            String id = input.ask("Введите ID заявки : ");
            for (int i = 0; i < tracker.findAll().length; i++) {
                if (tracker.findAll()[i].getId().equals(id)) {
                    String name = input.ask("Введите новое имя заявки : ");
                    String desc = input.ask("Введите новое описание заявки : ");
                    Item item = new Item(name, desc);
                    if (tracker.replace(id, item)) {
                        System.out.println("------------ Заявка отредактирована ------------");
                    } else {
                        System.out.println("------------ Неизвестная ошибка ------------");
                    }
                    break;
                } else if (i == tracker.findAll().length - 1 && !tracker.findAll()[tracker.findAll().length - 1].getId().equals(id)) {
                    System.out.println("------------ Заявка с таким ID не найдена ------------");
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактирование заявки");
        }
    }


    private class DeleteItems implements UserAction {

        public DeleteItems(Tracker tracker, Input input) {
        }

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ------------");
            String id = input.ask("Введите ID заявки : ");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка удалена ------------");
            } else {
                System.out.println("------------ Заявка с таким ID не найдена ------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки");
        }
    }

    private class FindById implements UserAction {

        public FindById(Tracker tracker, Input input) {
        }

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            String id = input.ask("Введите ID заявки : ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("------------ Заявка с таким ID не найдена ------------");
            } else {
                System.out.println("------------ " + item + "------------");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по ID");
        }
    }

    private class FindByName implements UserAction {

        public FindByName(Tracker tracker, Input input) {
        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени ------------");
            String name = input.ask("Введите имя заявки : ");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                System.out.println("------------ Заявок с таким именем не найдено ------------");
            } else {
                System.out.println(Arrays.toString(items));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявок по имени");
        }
    }
}
