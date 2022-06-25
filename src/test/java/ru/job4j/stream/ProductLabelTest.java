package ru.job4j.stream;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductLabelTest {

    @Test
    public void generateLabels() {
        ProductLabel label = new ProductLabel();
        List<Product> products = Arrays.asList(
                new Product("Milk", 60.5f, new GregorianCalendar(
                                                2022, Calendar.JUNE, 26)),
                new Product("Juice", 85f, new GregorianCalendar(
                                                2022, Calendar.NOVEMBER, 28)),
                new Product("Pizza", 250f, new GregorianCalendar(
                                                2022, Calendar.JUNE, 27))
        );
        List<String> rsl = label.generateLabels(products);
        assertThat(rsl.size(), is(2));
        assertTrue(rsl.get(0).contains("50% off"));
        assertTrue(rsl.get(1).contains("125"));
    }
}