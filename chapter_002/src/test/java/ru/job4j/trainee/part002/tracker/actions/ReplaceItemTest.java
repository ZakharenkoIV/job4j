package ru.job4j.trainee.part002.tracker.actions;

import org.junit.Test;
import org.mockito.stubbing.Answer;
import ru.job4j.trainee.part002.tracker.Input;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.MemTracker;
import ru.job4j.trainee.part002.tracker.Store;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReplaceItemTest {

    @Test
    public void execute() throws SQLException, IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Store tracker = new MemTracker();
        int id = tracker.add(new Item("Заменяемая заявка")).getId();
        String replacedName = "Новое имя заявки";
        ReplaceItem rep = new ReplaceItem();

        Input input = mock(Input.class);

        when(input.askInt(any(String.class)))
                .thenAnswer((Answer) invocation -> {
                    System.out.println(invocation.getArguments()[0]);
                    return id;
                });
        when(input.askStr(any(String.class)))
                .thenAnswer((Answer) invocation -> {
                    System.out.println(invocation.getArguments()[0]);
                    return replacedName;
                });


        rep.execute(input, tracker);

        out.flush();
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Введите ID заявки : " + ln
                + "Введите имя заявки : " + ln
                + "Заявка отредактирована" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }
}