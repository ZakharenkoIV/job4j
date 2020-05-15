package ru.job4j.trainee.part003.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] stringSplit1 = o1.split("/");
        String[] stringSplit2 = o2.split("/");
        int result = o2.compareTo(o1);
        if (stringSplit1[0].equals(stringSplit2[0])) {
            result = o1.compareTo(o2);
        }
        return result;
    }
}