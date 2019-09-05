package ru.job4j.trainee.part002.tracker;

public class TrackerSingleNested {

    private TrackerSingleNested() {
    }

    public static TrackerSingleNested getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleNested INSTANCE = new TrackerSingleNested();
    }
}

