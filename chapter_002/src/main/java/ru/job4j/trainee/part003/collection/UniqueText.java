package ru.job4j.trainee.part003.collection;

import java.util.Collections;
import java.util.HashSet;

public class UniqueText {
    public static boolean stringComparison(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        Collections.addAll(check, origin);
        boolean stringsEqual = true;
        for (String string : duplicate) {
            if (!check.contains(string)) {
                stringsEqual = false;
                break;
            }
        }
        return stringsEqual;
    }
}
