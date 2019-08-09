package ru.job4j.trainee.part002.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    Tracker tracker = new Tracker();
    Item item1 = tracker.add(new Item("test name1", "desc1"));
    Item item2 = tracker.add(new Item("test name2", "desc2"));
    Item item3 = tracker.add(new Item("test name2", "desc3"));
    Input input1 = new StubInput(new String[]{"1", "6"});
    Input input2 = new StubInput(new String[]{"4", item2.getId(), "6"});
    Input input3 = new StubInput(new String[]{"5", item3.getName(), "6"});
    String menu = "Меню"
            + "\r\n" + "(0) Добавить новую заявку"
            + "\r\n" + "(1) Показать все заявки"
            + "\r\n" + "(2) Редактировать заявку"
            + "\r\n" + "(3) Удалить заявку"
            + "\r\n" + "(4) Найти заявку по ID"
            + "\r\n" + "(5) Найти заявку по имени"
            + "\r\n" + "(6) Выход";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    @Test
    public void whenUserShowAllItems() {
        new StartUI(input1, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(menu)
                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append("\r\n" + "------------ Все заявки ------------")
                        .append("\r\n" + Arrays.toString(tracker.findAll()))
                        .append("\r\n")
                        .append(menu)
                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    @Test
    public void whenUserFindItemById() {
        new StartUI(input2, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(menu)
                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append("\r\n" + "------------ Поиск заявки по ID ------------")
                        .append("\r\n" + "Введите ID заявки : ")
                        .append("\r\n" + "------------ " + item2 + "------------")
                        .append("\r\n")
                        .append(menu)
                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    @Test
    public void whenUserFindItemsByName() {
        new StartUI(input3, tracker).init();
        Item[] items = this.tracker.findByName(item3.getName());
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(menu)
                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append("\r\n" + "------------ Поиск заявок по имени ------------")
                        .append("\r\n" + "Введите имя заявки : ")
                        .append("\r\n" + Arrays.toString(items))
                        .append("\r\n")
                        .append(menu)
                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }
}
