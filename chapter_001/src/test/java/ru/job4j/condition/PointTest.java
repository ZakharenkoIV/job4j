package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void when() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(4, 2);
        assertThat(point1.distanceTo(point2), closeTo(3.0, 0.1));
    }
}
