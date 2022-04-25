package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void when00and40and04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void when14and54and74ThenNoTriangle() {
        Point a = new Point(1, 4);
        Point b = new Point(5, 4);
        Point c = new Point(7, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        int expected = -1;
        Assert.assertEquals(rsl, expected, 0.01);
    }
}