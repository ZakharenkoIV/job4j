package ru.job4j.trainee.part002.patterns.strategy;

public class Triangle implements Shape {

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder()
                .append("   +   ")
                .append("  +++  ")
                .append(" +++++ ")
                .append("+++++++");
        return sb.toString();
    }
}
