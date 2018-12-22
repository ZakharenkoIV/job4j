package ru.job4j.loop;

public class Paint {
    public String firstHalfPyramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int height = 1; height <= h; height++) {
            for (int width = 1; width <= h; width++) {
                if (height >= width) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }

    public String secondHalfPyramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int height = 1; height <= h; height++) {
            for (int width = 1; width <= h; width++) {
                if (h - height + 1 <= width) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }

    public String pyramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int height = 1; height <= h; height++) {
            for (int width = 1; width <= h * 2 - 1; width++) {
                if (height >= h - width + 1 && h + height - 1 >= width) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}