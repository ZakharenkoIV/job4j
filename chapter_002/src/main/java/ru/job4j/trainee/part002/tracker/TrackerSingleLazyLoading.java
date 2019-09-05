package ru.job4j.trainee.part002.tracker;

public class TrackerSingleLazyLoading extends Tracker {
    private static TrackerSingleLazyLoading instance;

    private TrackerSingleLazyLoading() {
    }

    public static TrackerSingleLazyLoading getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyLoading();
        }
        return instance;
    }
}

