package ru.job4j.trainee.part003.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {

        StringBuilder numberLeft = new StringBuilder();
        char[] charsLeft = left.toCharArray();
        for (char c : charsLeft) {
            if (Character.isDigit(c)) {
                numberLeft.append(c);
            } else {
                break;
            }
        }

        StringBuilder numberRight = new StringBuilder();
        char[] charsRight = right.toCharArray();
        for (char c : charsRight) {
            if (Character.isDigit(c)) {
                numberRight.append(c);
            } else {
                break;
            }
        }

        return Integer.compare(
                Integer.parseInt(numberLeft.toString()),
                Integer.parseInt(numberRight.toString())
        );
    }
}