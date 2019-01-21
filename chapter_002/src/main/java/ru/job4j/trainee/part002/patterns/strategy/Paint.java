package ru.job4j.trainee.part002.patterns.strategy;

public class Paint {
    private Shape shape;

    public Paint(Shape shape) {
        this.shape = shape;
    }

    public void giveShape() {
        System.out.println(shape.draw());
    }
}
