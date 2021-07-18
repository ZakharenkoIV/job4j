package ru.job4j.trainee.part002.tracker.actions;

import org.junit.Test;
import org.mockito.stubbing.Answer;
import ru.job4j.trainee.part002.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameItemTest {

    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker memTracker = new MemTracker();
        Item item = new Item("fix bug");
        memTracker.add(item);
        FindByNameItem act = new FindByNameItem();
        act.execute(new StubInput(new String[]{"fix bug"}), memTracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\n" + "Имя заявки:" + " " + item.getName() + "\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void execute() throws SQLException, IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Store tracker = new MemTracker();
        String id = tracker.add(new Item("Искомая заявка")).getId();
        FindByNameItem fName = new FindByNameItem();

        Input input = mock(Input.class);

        when(input.askStr(any(String.class)))
                .thenAnswer((Answer) invocation -> {
                    System.out.println(invocation.getArguments()[0]);
                    return "Искомая заявка";
                });

        fName.execute(input, tracker);

        out.flush();
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Введите имя заявки : " + ln
                + "\n" + "Имя заявки: Искомая заявка" + "\n" + ln));
        assertThat(tracker.findById(id).getName(), is("Искомая заявка"));
    }
}
