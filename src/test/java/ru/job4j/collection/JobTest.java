package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    void whenComparatorForwardByName() {
        Comparator<Job> comparator = new JobAscByName();
        int rsl = comparator.compare(
                new Job("Main task", 0),
                new Job("Second task", 1)
        );
        assertThat(rsl).isNegative();
    }

    @Test
    void whenComparatorForwardByPriority() {
        Comparator<Job> comparator = new JobAscByPriority();
        int rsl = comparator.compare(
                new Job("Main task", 0),
                new Job("Second task", 1)
        );
        assertThat(rsl).isNegative();
    }

    @Test
    void whenComparatorBackwardByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Main task", 0),
                new Job("Second task", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    void whenComparatorBackwardByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Main task", 0),
                new Job("Second task", 1)
        );
        assertThat(rsl).isPositive();
    }

    @Test
    void whenForwardEquals() {
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(
                new Job("Main task", 0),
                new Job("Main task", 0)
        );
        assertThat(rsl).isZero();
    }

    @Test
    void whenBackwardEquals() {
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(
                new Job("Second task", 1),
                new Job("Second task", 1)
        );
        assertThat(rsl).isZero();
    }
}