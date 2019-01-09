package ru.job4j;

/**
 * Class Examination Решение задачи из устного экзамена части 001 базового синтаксиса.
 *
 * @author Ilya Zakharenko (ZakharenkoIV@yandex.ru)
 * @since 05.01.2019
 */
public class Examination {

    /**
     * Метод объединяет два отсортированных по возрастанию массива в один отсортированный массив.
     *
     * @param firstArray  Первый отсортированный массив.
     * @param secondArray Второй отсортированный массив.
     * @return Объединённый отсортированный массив.
     */
    public int[] addSortedArray(int[] firstArray, int[] secondArray) {
        int[] combinedArray = new int[firstArray.length + secondArray.length];
        int firstPosition = 0, secondPosition = 0;
        while (firstPosition != firstArray.length && secondArray.length != secondPosition) {
            if (firstArray[firstPosition] < secondArray[secondPosition]) {
                combinedArray[firstPosition + secondPosition] = firstArray[firstPosition++];
            } else {
                combinedArray[firstPosition + secondPosition] = secondArray[secondPosition++];
            }
        }
        while (firstPosition + secondPosition < combinedArray.length) {
            if (firstPosition == firstArray.length) {
                combinedArray[firstPosition + secondPosition] = secondArray[secondPosition++];
            } else {
                combinedArray[firstPosition + secondPosition] = firstArray[firstPosition++];
            }
        }
        return combinedArray;
    }
}