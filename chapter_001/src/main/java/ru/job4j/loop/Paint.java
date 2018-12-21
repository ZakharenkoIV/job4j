package ru.job4j.loop;

public class Paint {
    public String piramid(int h) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int height = 0; height != h; height++) {
            for (int width = 0; width != h*2-1; width++) {
                if (height >= h- width - 1 && width <= height + h - 1) {
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
