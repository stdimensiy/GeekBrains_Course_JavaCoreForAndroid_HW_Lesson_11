package ru.geekbrains.JavaCoreForAndroid;

import java.util.Arrays; // в данном примере использую чтобы быстро использовать встроенный метод toString
/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 11
 * Created 14.02.2021
 * v1.0
 */
public class Lesson11 {
    public static void main(String[] args) {
        //Задание №1
        Integer[] testArr1 = {1, 2, 3, 4};
        System.out.print("Первоначальное состояние массива arr:");
        System.out.println(Arrays.toString(testArr1));
        SwapTwoArrayElements(testArr1, 1, 2);
        System.out.print("Результат работы метода перестановки:");
        System.out.println(Arrays.toString(testArr1));
        String[] testArr2 = {"Первый", "Второй", "Третий", "Четвертый"};
        System.out.print("Первоначальное состояние массива arr:");
        System.out.println(Arrays.toString(testArr2));
        SwapTwoArrayElements(testArr2, 1, 2);
        System.out.print("Результат работы метода перестановки:");
        System.out.println(Arrays.toString(testArr2));
    }

    // Метод работает с обобщенным типом данных, теперь ему все равно какой массив придет на вход.
    public static <T> void SwapTwoArrayElements(T[] modifiableArray, int elemNum1, int elemNum2) {
        T backupElement = modifiableArray[elemNum1];
        modifiableArray[elemNum1] = modifiableArray[elemNum2];
        modifiableArray[elemNum2] = backupElement;
    }
}
