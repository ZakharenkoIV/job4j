package ru.job4j.trainee.part002.tracker.comparator.item;

import org.junit.Test;
import ru.job4j.trainee.part002.tracker.Item;
import ru.job4j.trainee.part002.tracker.comparators.item.SortByNameAscending;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortByNameAscendingTest {

    @Test
    public void sortByNameAscendingTest() {
        Item itemA = new Item("A");
        Item itemB = new Item("B");
        Item itemC = new Item("C");
        List<Item> input = new ArrayList<>(List.of(itemC, itemB, itemA));
        input.sort(new SortByNameAscending());
        List<Item> expected = List.of(itemA, itemB, itemC);
        assertThat((input), is(expected));
    }
}
