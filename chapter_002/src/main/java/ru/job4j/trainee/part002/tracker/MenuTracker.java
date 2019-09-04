package ru.job4j.trainee.part002.tracker;

import java.util.Arrays;

public class MenuTracker {
    private Tracker tracker;
    private Input input;
    private int range = 7;
    //Композиция
    private UserAction[] action = new UserAction[range];
    //Агрегация
    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    public int[] rangeMenu() {
        int[] num = new int[range];
        for (int i = 0; i < range; i++) {
            num[i] = i;
        }
        return num;
    }

    public void fillAction() {
        this.action[0] = new AddItem(0, "Добавить новую заявку");
        this.action[1] = new ShowAllItems(1, "Показать все заявки");
        this.action[2] = new EditItems(2, "Редактировать заявку");
        this.action[3] = new DeleteItems(3, "Удалить заявку");
        this.action[4] = new FindById(4, "Найти заявку по ID");
        this.action[5] = new FindByName(5, "Найти заявку по имени");
        this.action[6] = new Exit(6, "Выход");
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

    //Наследование
    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
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
    }

    //Наследование
    private class ShowAllItems extends BaseAction {

        protected ShowAllItems(int key, String name) {
            super(key, name);
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

    //Наследование
    private class EditItems extends BaseAction {

        protected EditItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки ------------");
            String id = input.ask("Введите ID заявки : ");
            tracker.findById(id).setName(input.ask("Введите новое имя заявки : "));
            tracker.findById(id).setDesc(input.ask("Введите новое описание заявки : "));
            System.out.println("------------ Заявка отредактирована ------------");
        }
    }

    //Наследование
    private class DeleteItems extends BaseAction {

        protected DeleteItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ------------");
            tracker.delete(input.ask("Введите ID заявки : "));
        }
    }

    //Наследование
    private class FindById extends BaseAction {

        protected FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            System.out.println("------------ " + tracker.findById(input.ask("Введите ID заявки : ")) + "------------");
        }
    }

    //Наследование
    private class FindByName extends BaseAction {

        protected FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени ------------");
            System.out.println(Arrays.toString(tracker.findByName(input.ask("Введите имя заявки : "))));
        }
    }

    //Наследование
    private class Exit extends BaseAction {

        protected Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            tracker.setExitProgram(false);
        }
    }
}

