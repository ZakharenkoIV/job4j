package ru.job4j.trainee.part003.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {
    @Test
    public void whenExtractNumberGetNotUniqueListThenReturnUniqueHashSetList() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "one"),
                new Task("2", "two"),
                new Task("1", "one")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}
