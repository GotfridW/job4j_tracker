package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3f67", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3f67"), is(new Order("3f67", "Dress")));
    }

    @Test
    public void whenDuplicateOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("2s46", "Toyota"));
        orders.add(new Order("2s46", "Toyota"));
        orders.add(new Order("3g87", "Mazda"));
        orders.add(new Order("3g87", "Mazda"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(2));
    }
}