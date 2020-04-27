package ru.job4j.trainee.part002.tracker.comparator.item;

import org.junit.Test;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.comparators.item.SortByNameDescending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortByNameDescendingTest {

    @Test
    public void sortByNameAscendingTest() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("d"));
        items.add(new Item("c"));
        items.add(new Item("a"));
        items.add(new Item("b"));
        items.sort(new SortByNameDescending());
        String actual = "[\n" + "Имя заявки: d\n"
                     + ", \n" + "Имя заявки: c\n"
                     + ", \n" + "Имя заявки: b\n"
                     + ", \n" + "Имя заявки: a\n" + "]";
        assertThat((items.toString()), is(actual));
    }
}
