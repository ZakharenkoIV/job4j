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
        int iSmaller = 0, iDigger = 0;
        int[] smallerArray, biggerArray;
        if (firstArray.length < secondArray.length) {
            smallerArray = firstArray;
            biggerArray = secondArray;
        } else {
            smallerArray = secondArray;
            biggerArray = firstArray;
        }
        for (int i = 0; iSmaller < smallerArray.length; i++) {
            if (smallerArray[iSmaller] < biggerArray[iDigger]) {
                combinedArray[i] = smallerArray[iSmaller];
                iSmaller++;
            } else {
                combinedArray[i] = biggerArray[iDigger];
                iDigger++;
            }
            if (smallerArray.length == biggerArray.length && iSmaller == smallerArray.length - 1 && iDigger == biggerArray.length - 1) {
                break;
            }
        }
        if (smallerArray.length != biggerArray.length) {
            for (int iCombined = iSmaller + iDigger; iCombined < combinedArray.length; iCombined++, iDigger++) {
                combinedArray[iCombined] = biggerArray[iDigger];
            }
        } else {
            for (; iSmaller + iDigger < combinedArray.length; iSmaller++, iDigger++) {
                if (smallerArray[iSmaller] < biggerArray[iDigger]) {
                    combinedArray[iSmaller + iDigger] = smallerArray[iSmaller];
                    combinedArray[iSmaller + iDigger + 1] = biggerArray[iDigger];
                } else {
                    combinedArray[iSmaller + iDigger] = biggerArray[iDigger];
                    combinedArray[iSmaller + iDigger + 1] = smallerArray[iSmaller];
                }
            }
        }
        return combinedArray;
    }
}