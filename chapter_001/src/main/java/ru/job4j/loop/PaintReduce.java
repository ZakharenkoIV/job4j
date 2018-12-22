package ru.job4j.loop;

import java.util.function.BiPredicate;

public class PaintReduce {
    private String loopBy(int h1, int h2, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int height = 1; height <= h1; height++) {
            for (int width = 1; width <= h2; width++) {
                if (predict.test(height, width)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    public String firstHalfPyramid(int h) {
        return this.loopBy(
                h,
                h,
                (height, width) -> height >= width
        );
    }

    public String secondHalfPyramid(int h) {
        return this.loopBy(
                h,
                h,
                (height, width) -> h - height + 1 <= width
        );
    }

    public String pyramid(int h) {
        return this.loopBy(
                h,
                h * 2 - 1,
                (height, width) -> height >= h - width + 1 && h + height - 1 >= width
        );
    }
}