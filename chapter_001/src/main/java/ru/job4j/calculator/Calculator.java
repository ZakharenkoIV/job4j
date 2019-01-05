package ru.job4j.calculator;

/**
 * Class Calculator for calculation addition, subtraction, division or multiplication.
 *
 * @author Ilya Zakharenko (ZakharenkoIV@yandex.ru)
 * @since 18.12.2018
 */
public class Calculator {
    /**
     * Result of arithmetic action.
     */
    private double result;

    /**
     * Method add.
     *
     * @param first  - first number.
     * @param second - second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     *
     * @param first  - first number.
     * @param second - second number.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     *
     * @param first  - first number.
     * @param second - second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     *
     * @param first  - first number.
     * @param second - second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     *
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}
