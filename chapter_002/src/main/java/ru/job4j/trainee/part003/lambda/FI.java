package ru.job4j.trainee.part003.lambda;

import java.util.Comparator;

public class FI {
    public static void main(String[] args) {

        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return right.getSize() - left.getSize();
        };
    }
}
