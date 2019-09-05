package ru.job4j.trainee.part002.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void whenTwoReferencesTrackerSingleEnum() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenTwoReferencesTrackerSingleLazyLoading() {
        TrackerSingleLazyLoading tracker1 = TrackerSingleLazyLoading.getInstance();
        TrackerSingleLazyLoading tracker2 = TrackerSingleLazyLoading.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenTwoReferencesTrackerSingleEagerLoading() {
        TrackerSingleEagerLoading tracker1 = TrackerSingleEagerLoading.getInstance();
        TrackerSingleEagerLoading tracker2 = TrackerSingleEagerLoading.getInstance();
        assertThat(tracker1, is(tracker2));
    }

    @Test
    public void whenTwoReferencesTrackerSingleNested() {
        TrackerSingleNested tracker1 = TrackerSingleNested.getInstance();
        TrackerSingleNested tracker2 = TrackerSingleNested.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}
