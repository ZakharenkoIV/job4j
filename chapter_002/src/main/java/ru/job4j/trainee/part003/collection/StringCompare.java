package ru.job4j.trainee.part003.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] charsLeft = left.toCharArray();
        char[] charsRight = right.toCharArray();

        int rsl = 0;
        int i = 0;
        for (; i < charsLeft.length && i < charsRight.length; i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && charsLeft.length != charsRight.length && charsLeft.length == i) {
            rsl = -3;
        }
        if (rsl == 0 & charsLeft.length != charsRight.length && charsRight.length == i) {
            rsl = 3;
        }
        return rsl;
    }
}
