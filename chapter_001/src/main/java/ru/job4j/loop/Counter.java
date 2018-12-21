package ru.job4j.loop;

public class Counter {

    public int add(int start, int finish) {
        int result = 0;
        if (start > finish) {
            result = -1;
        } else {
            for (; start <= finish; start++) {
                if (start % 2 == 0) {
                    result = result + start;
                }
            }
        }
        return result;
    }
}
