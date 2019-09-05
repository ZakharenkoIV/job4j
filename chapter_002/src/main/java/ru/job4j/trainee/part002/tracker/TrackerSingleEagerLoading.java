package ru.job4j.trainee.part002.tracker;

public class TrackerSingleEagerLoading {
    private static final TrackerSingleEagerLoading INSTANCE = new TrackerSingleEagerLoading();

    private TrackerSingleEagerLoading() {
    }

    public static TrackerSingleEagerLoading getInstance() {
        return INSTANCE;
    }

    private Item[] items = new Item[100];
    private boolean exitProgram = true;
}

