package ru.job4j.loop;

public class Counter {

    public int add(int start, int finish) {
        int result = -1;
        if (start > finish) {
            return result;
        }
        for (; start <= finish; start++) {
            if (start % 2 == 0) {
                result = result + start;
            }
        }
        return result + 1;
    }
}
