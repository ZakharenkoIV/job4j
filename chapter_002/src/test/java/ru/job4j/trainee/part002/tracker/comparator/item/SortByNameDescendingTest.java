package ru.job4j.trainee.part002.tracker.comparator.item;

import org.junit.Test;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.comparators.item.SortByNameDescending;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortByNameDescendingTest {

    @Test
    public void sortByNameDescendingTest() {
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemC = new Item("C");
        List<Item> input = new ArrayList<>(List.of(itemA, itemB, itemC));
        input.sort(new SortByNameDescending());
        List<Item> expected = List.of(itemC, itemB, itemA);
        assertThat((input), is(expected));
    }
}
