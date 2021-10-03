package ru.job4j.trainee.part002.tracker.actions;

import org.junit.Test;
import ru.job4j.trainee.part002.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.StringJoiner;

public class FindAllItemTest {

    @Test
    public void whenCheckOutput() throws SQLException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Store tracker = new MemTracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindAllItem act = new FindAllItem();
        act.execute(new StubInput(new String[]{}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("\n" + "Имя заявки:" + " " + item.getName() + "\n")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
