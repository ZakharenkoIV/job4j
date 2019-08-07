package ru.job4j.trainee.part002.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private static PrintStream stdout = System.out;
    private static ByteArrayOutputStream out = new ByteArrayOutputStream();
    Tracker tracker = new Tracker();
    Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
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
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                        .append(menu)
//                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append("\r\n" + "------------ Добавление новой заявки ------------")
//                        .append("\r\n" + "Введите имя заявки : ")
//                        .append("\r\n" + "Введите описание заявки : ")
                        .append("\r\n" + "------------ ID новой заявки : " + StartUI.idOfLastItemAdded + "------------")
                        .append("\r\n")
                        .append(menu)
//                        .append("\r\n" + "Ввеедите пункт меню : ")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }
}
