package ru.job4j.range;

import java.util.ArrayList;
import java.util.List;

public class FunctionInRange {
    List<Double> diapason(int start, int end, java.util.function.Function<Double, Double> func) {
        List<Double> range = new ArrayList<>();
        for (int i = start; i < end; i++) {
            range.add(func.apply((double) i));
        }
        return range;
    }
}
