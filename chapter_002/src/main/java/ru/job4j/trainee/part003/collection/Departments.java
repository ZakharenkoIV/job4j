package ru.job4j.trainee.part003.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.concat(el);
                tmp.add(start);
                start = start.concat("/");
            }
        }
        List<String> rsl = new ArrayList<>(tmp);
        sortAsc(rsl);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        DepDescComp depDescComp = new DepDescComp();
        orgs.sort(depDescComp);
    }
}