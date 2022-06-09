package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String a = o1.split("/")[0];
        String b = o2.split("/")[0];
        int cmpAB = b.compareTo(a);
        return cmpAB == 0 ? o1.compareTo(o2) : cmpAB;
    }
}
