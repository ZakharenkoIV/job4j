package ru.job4j.trainee.part002.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenReturnNewListItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item.getId());
        Item[] expected = new Item[]{item2, item3};
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenAddThenReturnOll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expected = new Item[]{item, item2, item3};
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void whenFindByNameThenReturnItemWithThisName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item[] expect = new Item[]{item3};
        assertThat(tracker.findByName("test3"), is(expect));
    }

    @Test
    public void whenFindByIdThenReturnItemWithThisId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 123L);
        Item item3 = new Item("test3", "testDescription", 123L);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }
}
