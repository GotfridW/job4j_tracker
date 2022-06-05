package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String shortest = left.length() <= right.length() ? left : right;
        for (int i = 0; i < shortest.length(); i++) {
            int cmpByChar = Character.compare(left.charAt(i), right.charAt(i));
            if (cmpByChar != 0) {
                rsl = cmpByChar;
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
