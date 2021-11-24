package ru.job4j.trainee.part002.tracker.store;

import org.junit.Test;
import ru.job4j.trainee.part002.tracker.HbmTracker;
import ru.job4j.trainee.part002.tracker.Item;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HbmTrackerTest {

    @Test
    public void whenAddAndFindById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item actual = new Item("name", "description");
        hbmTracker.add(actual);
        Item expect = hbmTracker.findById(1);
        assertEquals(expect, actual);
    }

    @Test
    public void whenReplace() {
        HbmTracker hbmTracker = new HbmTracker();
        Item actual = new Item("name", "description");
        hbmTracker.add(actual);
        actual.setName("new name");
        hbmTracker.replace(1, actual);
        Item expect = hbmTracker.findById(1);
        assertEquals(expect, actual);
    }

    @Test
    public void whenDelete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item actual = new Item("name", "description");
        hbmTracker.add(actual);
        hbmTracker.delete(1);
        Item expect = hbmTracker.findById(1);
        assertNull(expect);
    }

    @Test
    public void whenFindAll() {
        HbmTracker hbmTracker = new HbmTracker();
        List<Item> actual = new ArrayList<>();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        actual.add(item1);
        actual.add(item2);
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        List<Item> expect = hbmTracker.findAll();
        assertEquals(expect, actual);
    }

    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        List<Item> actual = new ArrayList<>();
        Item item1 = new Item("name", "description1");
        Item item2 = new Item("name", "description2");
        actual.add(item1);
        actual.add(item2);
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        List<Item> expect = hbmTracker.findByName("name");
        assertEquals(expect, actual);
    }
}