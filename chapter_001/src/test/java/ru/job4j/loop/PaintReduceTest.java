package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintReduceTest {

    @Test
    public void whenFirstHalfPyramid() {
        PaintReduce paintReduce = new PaintReduce();
        String rsl = paintReduce.firstHalfPyramid(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("^    %s^^   %s^^^  %s^^^^ %s^^^^^%s", ln, ln, ln, ln, ln)
                )
        );
    }

    @Test
    public void whenSecondHalfPyramid() {
        PaintReduce paintReduce = new PaintReduce();
        String rsl = paintReduce.secondHalfPyramid(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("    ^%s   ^^%s  ^^^%s ^^^^%s^^^^^%s", ln, ln, ln, ln, ln)
                )
        );
    }

    @Test
    public void whenHeight2() {
        PaintReduce paintReduce = new PaintReduce();
        String rsl = paintReduce.pyramid(2);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format(" ^ %s^^^%s", ln, ln)
                )
        );
    }

    @Test
    public void whenHeight4() {
        PaintReduce paintReduce = new PaintReduce();
        String rsl = paintReduce.pyramid(3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("  ^  %s ^^^ %s^^^^^%s", ln, ln, ln)
                )
        );
    }
}
