package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (boolean i : data) {
            if (i == data[0]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}