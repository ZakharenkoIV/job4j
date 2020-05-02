package ru.job4j.trainee.part003.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(toNumber(left), toNumber(right));
    }

    private int toNumber(String line) {
        StringBuilder number = new StringBuilder();
        char[] chars = line.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                break;
            }
        }
        return Integer.parseInt(number.toString());
    }
}