package ru.job4j.range;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionInRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionInRange function = new FunctionInRange();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionInRange function = new FunctionInRange();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 2) + x + 1);
        List<Double> expected = Arrays.asList(7D, 13D, 21D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionInRange function = new FunctionInRange();
        List<Double> result = function.diapason(3, 6, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}