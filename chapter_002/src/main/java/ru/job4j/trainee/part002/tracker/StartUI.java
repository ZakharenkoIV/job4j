package ru.job4j.trainee.part002.tracker;

import java.util.Arrays;

public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private final Tracker tracker;
    private final Input input;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
//        boolean exit = false;
//        while (!exit) {
//            this.showMenu();
//            String answer = this.input.ask("Ввеедите пункт меню : ");
//            if (ADD.equals(answer)) {
//                this.createItem();
//            } else if (SHOW.equals(answer)) {
//                this.showAllItems();
//            } else if (EDIT.equals(answer)) {
//                this.editItems();
//            } else if (DELETE.equals(answer)) {
//                this.deleteItems();
//            } else if (FIND_BY_ID.equals(answer)) {
//                this.findById();
//            } else if (FIND_BY_NAME.equals(answer)) {
//                this.findByName();
//            } else if (EXIT.equals(answer)) {
//                exit = true;
//            }
//        }
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.tracker, this.input);
        menu.fillAction();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Выберите пункт меню"));
            menu.select(key);
        } while (!"да".equals(this.input.ask("Выход? (да): ")));
    }

    private void showMenu() {
        System.out.println("Меню");
        System.out.println("(0) Добавить новую заявку");
        System.out.println("(1) Показать все заявки");
        System.out.println("(2) Редактировать заявку");
        System.out.println("(3) Удалить заявку");
        System.out.println("(4) Найти заявку по ID");
        System.out.println("(5) Найти заявку по имени");
        System.out.println("(6) Выход");
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки ------------");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");
        Item item = new Item(name, desc);
        item = this.tracker.add(item);
        System.out.println("------------ ID новой заявки : " + item.getId() + "------------");
    }

    private void showAllItems() {
        System.out.println("------------ Все заявки ------------");
        System.out.println(Arrays.toString(tracker.findAll()));
    }

    private void editItems() {
        System.out.println("------------ Редактирование заявки ------------");
        String id = this.input.ask("Введите ID заявки : ");
        for (int i = 0; i < tracker.findAll().length; i++) {
            if (tracker.findAll()[i].getId().equals(id)) {
                String name = this.input.ask("Введите новое имя заявки : ");
                String desc = this.input.ask("Введите новое описание заявки : ");
                Item item = new Item(name, desc);
                if (this.tracker.replace(id, item)) {
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

    private void deleteItems() {
        System.out.println("------------ Удаление заявки ------------");
        String id = this.input.ask("Введите ID заявки : ");
        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка удалена ------------");
        } else {
            System.out.println("------------ Заявка с таким ID не найдена ------------");
        }
    }

    private void findById() {
        System.out.println("------------ Поиск заявки по ID ------------");
        String id = this.input.ask("Введите ID заявки : ");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("------------ Заявка с таким ID не найдена ------------");
        } else {
            System.out.println("------------ " + item + "------------");
        }
    }

    private void findByName() {
        System.out.println("------------ Поиск заявок по имени ------------");
        String name = this.input.ask("Введите имя заявки : ");
        Item[] items = this.tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("------------ Заявок с таким именем не найдено ------------");
        } else {
            System.out.println(Arrays.toString(items));
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
