package ru.job4j.trainee.part002.tracker;

import org.junit.Test;
import ru.job4j.trainee.part002.tracker.actions.UserAction;
import ru.job4j.trainee.part002.tracker.actions.StubAction;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        ArrayList<UserAction> arrayList = new ArrayList<>();
        arrayList.add(action);
        new StartUI().init(input, new MemTracker(), arrayList);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[]{"0"}
        );
        StubAction action = new StubAction();
        List<UserAction> userAction = new ArrayList<>();
        userAction.add(action);
        new StartUI().init(input, new MemTracker(), userAction);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Меню:")
                .add("0. Обрезанное действие")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
