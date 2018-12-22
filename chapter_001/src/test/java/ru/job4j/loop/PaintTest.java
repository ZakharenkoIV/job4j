package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {

    @Test
    public void whenFirstHalfPyramid() {
        Paint paint = new Paint();
        String rsl = paint.firstHalfPyramid(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("^    %s^^   %s^^^  %s^^^^ %s^^^^^%s", ln, ln, ln, ln, ln)
                )
        );
    }

    @Test
    public void whenSecondHalfPyramid() {
        Paint paint = new Paint();
        String rsl = paint.secondHalfPyramid(5);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("    ^%s   ^^%s  ^^^%s ^^^^%s^^^^^%s", ln, ln, ln, ln, ln)
                )
        );
    }

    @Test
    public void whenHeight2() {
        Paint paint = new Paint();
        String rsl = paint.pyramid(2);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format(" ^ %s^^^%s", ln, ln)
                )
        );
    }

    @Test
    public void whenHeight4() {
        Paint paint = new Paint();
        String rsl = paint.pyramid(3);
        String ln = System.lineSeparator();
        assertThat(rsl, is(
                String.format("  ^  %s ^^^ %s^^^^^%s", ln, ln, ln)
                )
        );
    }
}
