package ru.job4j.trainee.part002.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {
    MemTracker memTracker;
    Item item, item2, item3;

    @Before
    public void loadOutput() {
        memTracker = new MemTracker();
        item = new Item("test1");
        item2 = new Item("test2");
        item3 = new Item("test3");
        memTracker.add(item);
        memTracker.add(item2);
        memTracker.add(item3);
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        assertThat(memTracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item next = new Item("test4");
        next.setId(item.getId());
        memTracker.replace(item.getId(), next);
        assertThat(memTracker.findById(item.getId()).getName(), is("test4"));
    }

    @Test
    public void whenDeleteItemThenReturnNewListItems() {
        memTracker.delete(item3.getId());
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item2);
        assertThat(memTracker.findAll(), is(expected));
    }

    @Test
    public void whenAddThenReturnOll() {
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);
        expected.add(item2);
        expected.add(item3);
        assertThat(memTracker.findAll(), is(expected));
    }

    @Test
    public void whenFindByNameThenReturnItemWithThisName() {
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item3);
        assertThat(memTracker.findByName("test3"), is(expected));
    }

    @Test
    public void whenFindByIdThenReturnItemWithThisId() {
        assertThat(memTracker.findById(item2.getId()), is(item2));
    }
}
