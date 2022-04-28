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

    @Test
    public void whenThis351That575Then4dot89() {
        Point firstPoint = new Point(3, 5, 1);
        Point secondPoint = new Point(5, 7, 5);
        double rsl = firstPoint.distance3d(secondPoint);
        double expected = 4.89;
        Assert.assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void whenThis020That1047Then() {
        Point firstPoint = new Point(0, 2, 0);
        Point secondPoint = new Point(10, 4, 7);
        double rsl = firstPoint.distance3d(secondPoint);
        double expected = 12.36;
        Assert.assertEquals(rsl, expected, 0.01);
    }
}