package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int shortest = Math.min(left.length(), right.length());
        for (int i = 0; i < shortest; i++) {
            int cmpByChar = Character.compare(left.charAt(i), right.charAt(i));
            if (cmpByChar != 0) {
                rsl = cmpByChar;
                break;
            }
        }
        return rsl == 0 ? Integer.compare(left.length(), right.length()) : rsl;
    }
}
