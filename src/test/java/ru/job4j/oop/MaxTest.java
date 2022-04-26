package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void when2And3And5Then5() {
        int result = Max.max(2, 3, 5);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void when8And0And4Then8() {
        int result = Max.max(8, 0, 4);
        int expected = 8;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void when12And11And10And9Then12() {
        int result = Max.max(12, 11, 10, 9);
        int expected = 12;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void when0And5And15And2Then15() {
        int result = Max.max(0, 5, 15, 2);
        int expected = 15;
        Assert.assertEquals(result, expected);
    }
}