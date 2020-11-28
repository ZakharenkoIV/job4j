//package ru.job4j.trainee.part002.tracker.actions;
//
//import org.junit.Test;
//import ru.job4j.trainee.part002.tracker.Item;
//import ru.job4j.trainee.part002.tracker.MemTracker;
//import ru.job4j.trainee.part002.tracker.StubInput;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;
//
//import java.util.StringJoiner;
//
//public class FindByNameItemTest {
//
//    @Test
//    public void whenCheckOutput() {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PrintStream def = System.out;
//        System.setOut(new PrintStream(out));
//        MemTracker memTracker = new MemTracker();
//        Item item = new Item("fix bug");
//        memTracker.add(item);
//        FindByNameItem act = new FindByNameItem();
//        act.execute(new StubInput(new String[]{"fix bug"}), memTracker);
//        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
//                .add("\n" + "Имя заявки:" + " " + item.getName() + "\n")
//                .toString();
//        assertThat(new String(out.toByteArray()), is(expect));
//        System.setOut(def);
//    }
//}
