package ru.job4j.trainee.part002.sort;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] result = new int[100];
        int size = 0;
        for (int coin : coins) {
            while (money >= coin && money > price && money - price >= coin) {
                result[size] = coin;
                money = money - coin;
                size++;
            }
        }
        return Arrays.copyOf(result, size);
    }
}
