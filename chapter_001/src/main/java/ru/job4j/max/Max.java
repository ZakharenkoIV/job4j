package ru.job4j.max;

public class Max {

    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public int maxOfTheThree(int first, int second, int third) {
        int intermediate = max(first, second);
        return max(intermediate, third);
    }
}
