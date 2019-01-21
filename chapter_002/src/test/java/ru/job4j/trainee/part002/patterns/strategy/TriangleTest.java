package ru.job4j.trainee.part002.patterns.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        StringBuilder sb = new StringBuilder()
                .append("   +   ")
                .append("  +++  ")
                .append(" +++++ ")
                .append("+++++++");
        assertThat(triangle.draw(), is(sb.toString()));
    }
}
