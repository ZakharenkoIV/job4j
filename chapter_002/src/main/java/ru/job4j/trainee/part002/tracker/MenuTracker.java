package ru.job4j.trainee.part002.tracker;

import java.util.Arrays;

public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private UserAction[] action = new UserAction[7];

    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    public void fillAction() {
        this.action[0] = new AddItem();
        this.action[1] = new ShowAllItems();
        this.action[2] = new EditItems();
        this.action[3] = new DeleteItems();
        this.action[4] = new FindById();
        this.action[5] = new FindByName();
        this.action[6] = new Exit();
    }

    public void select(int key) {
        this.action[key].execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("Меню");
        for (UserAction action : this.action) {
            System.out.println(action.info());
        }
    }


    private class AddItem implements UserAction {

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
            return String.format("(%s) %s", this.key(), "Добавить новую заявку");
        }
    }

    private class ShowAllItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки ------------");
            System.out.println(Arrays.toString(tracker.findAll()));

        }

        @Override
        public String info() {
            return String.format("(%s) %s", this.key(), "Показать все заявки");
        }
    }

    private class EditItems implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки ------------");
            String id = input.ask("Введите ID заявки : ");
            tracker.findById(id).setName(input.ask("Введите новое имя заявки : "));
            tracker.findById(id).setDesc(input.ask("Введите новое описание заявки : "));
            System.out.println("------------ Заявка отредактирована ------------");
        }

        @Override
        public String info() {
            return String.format("(%s) %s", this.key(), "Редактировать заявку");
        }
    }


    private class DeleteItems implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ------------");
            tracker.delete(input.ask("Введите ID заявки : "));
        }

        @Override
        public String info() {
            return String.format("(%s) %s", this.key(), "Удалить заявку");
        }
    }

    private class FindById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            System.out.println("------------ " + tracker.findById(input.ask("Введите ID заявки : ")) + "------------");
        }

        @Override
        public String info() {
            return String.format("(%s) %s", this.key(), "Найти заявку по ID");
        }
    }

    private class FindByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени ------------");
            System.out.println(Arrays.toString(tracker.findByName(input.ask("Введите имя заявки : "))));
        }

        @Override
        public String info() {
            return String.format("(%s) %s", this.key(), "Найти заявку по имени");
        }
    }

    private class Exit implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.exitProgram = false;
        }

        @Override
        public String info() {
            return String.format("(%s) %s", this.key(), "Выход");
        }
    }
}

