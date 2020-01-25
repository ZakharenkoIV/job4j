package ru.job4j.trainee.part002.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    Tracker tracker;
    Item item, item2, item3;

    @Before
    public void loadOutput() {
        tracker = new Tracker();
        item = new Item("test1", "testDescription", 123L);
        item2 = new Item("test2", "testDescription", 123L);
        item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item next = new Item("test4", "testDescription2", 1234L);
        next.setId(item.getId());
        tracker.replace(item.getId(), next);
        assertThat(tracker.findById(item.getId()).getName(), is("test4"));
    }

    @Test
    public void whenDeleteItemThenReturnNewListItems() {
        tracker.delete(item3.getId());
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item2);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenAddThenReturnOll() {
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item2);
        expected.add(item3);
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenFindByNameThenReturnItemWithThisName() {
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item3);
        assertThat(tracker.findByName("test3"), is(expected));
    }

    @Test
    public void whenFindByIdThenReturnItemWithThisId() {
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
}
