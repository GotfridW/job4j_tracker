package ru.job4j.stream;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.Calendar.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class ProductLabelTest {

    @Test
    public void generateLabels() {
        ProductLabel label = new ProductLabel();
        List<Product> products = Arrays.asList(
                new Product("Milk", 60.5f, new GregorianCalendar()),
                new Product("Pizza", 250f, new GregorianCalendar())
        );
        List<String> rsl = label.generateLabels(products);
        assertThat(rsl.size(), is(2));
        assertTrue(rsl.get(0).contains("50% off"));
        assertTrue(rsl.get(1).contains("125"));
    }
}