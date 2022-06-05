package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class JobTest {
    @Test
    public void whenComparingByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Alex", 2),
                new Job("Harry", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparingByPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Alpha", 3),
                new Job("Beta", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparingByNameDesc() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Alpha", 6),
                new Job("Beta", 5)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparingByPriorityDesc() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Test", 4),
                new Job("Test", 4)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenComparingByNameAndPriority() {
        Comparator<Job> cmpNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Sleep", 1),
                new Job("Sleep", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparingByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority =
                new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpNamePriority.compare(
                new Job("Alpha", 1),
                new Job("Gamma", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}