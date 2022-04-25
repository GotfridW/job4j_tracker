package ru.job4j.oop;

import org.junit.Test;
import org.junit.Assert;

public class PointTest {

    @Test
    public void whenThis25That510Then5dot83() {
        Point firstPoint = new Point(2, 5);
        Point secondPoint = new Point(5, 10);
        double rsl = firstPoint.distance(secondPoint);
        double expected = 5.83;
        Assert.assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void whenThis89That98Then1dot41() {
        Point firstPoint = new Point(8, 9);
        Point secondPoint = new Point(9, 8);
        double rsl = firstPoint.distance(secondPoint);
        double expected = 1.41;
        Assert.assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void whenThis04That49Then6dot40() {
        Point firstPoint = new Point(0, 4);
        Point secondPoint = new Point(4, 9);
        double rsl = firstPoint.distance(secondPoint);
        double expected = 6.40;
        Assert.assertEquals(rsl, expected, 0.01);
    }
}