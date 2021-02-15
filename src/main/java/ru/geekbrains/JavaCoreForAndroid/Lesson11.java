package ru.geekbrains.JavaCoreForAndroid;

import java.util.ArrayList;
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

        //Задание 2
        // метод преобразующий обычный массив в ArrayList ( без использования методов библиотек Arrays, т.е. ручками)
        // Причем в какой конкретно ArrayList не сказано, следовательно нужно решить задачу в контексте обобщений
        ArrayList<Integer> listArr1 = new ArrayList();
        convertArrayToArrayList(listArr1, testArr1);
        System.out.print("Результат работы метода конвертации массива в ArrayList:");
        System.out.println(listArr1);
        ArrayList<String> listArr2 = new ArrayList();
        convertArrayToArrayList(listArr2, testArr2);
        System.out.print("Результат работы метода конвертации массива в ArrayList:");
        System.out.println(listArr2);
        System.out.println();
        //Задание 3
        System.out.println("Задание №3 (результаты и процесс...");
        // создаем коробку 1
        Box box1 = new Box();
        //кладем в нее 3 яблока
        box1.add(new Apple());
        box1.add(new Apple());
        box1.add(new Apple());
        // проверяем сколько весит коробка
        System.out.println("Вес коробки №1: " + box1.getWeight());
        // Создаем другую коробку
        Box box2 = new Box();
        //кладем в нее 3 яблока
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        // проверяем сколько весит коробка
        System.out.println("Вес коробки №2: " + box2.getWeight());
        // сравним две коробки
        System.out.println("Результат работы метода compare() класса Box, параметры (пример: box1.compare(box2))");
        System.out.println("Массы коробок " + (box1.compare(box2) ? "одинаковы" : "различны") + ".");
        // Проверка, а какие фрукты хранятся в каждой коробке
        // прямой способ получение ссылки на ArrayList и потом определение типа первого элемента
        // (аналог) открыли коробку и посмотрели что сверху
        System.out.println("В коробке Box1 хранятся " + box1.getProduct().get(0).getClass().getSimpleName());
        // создаем дополнительно еще одну коробку с яблоками
        Box box3 = new Box();
        //кладем в нее 3 яблока
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        box3.add(new Apple());
        // проверяем сколько весит коробка
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("В коробке Box3 хранятся " + box3.getProduct().get(0).getClass().getSimpleName());
        // пересыпаем яблоки из коробки 1 в коробку 3
        box1.shiftSingleItem(box3);
        // проверяем сколько весит коробка 3
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("Вес коробки №1: " + box1.getWeight());
        // а теперь попробуем апельсины выгрузить в яблоки
        try {
            box2.shiftSingleItem(box3);
        } catch (BoxCustomException e) {
            System.out.println(e);
        }
        System.out.println("Вес коробки №3: " + box3.getWeight());
        System.out.println("Вес коробки №2: " + box2.getWeight());
        // попытаемся положить несколько апельсинов в коробку с яблоками
        try {
            box3.add(new Orange());
            box3.add(new Orange());
            box3.add(new Orange());
        } catch (BoxCustomException e) {
            System.out.println(e);
        }
        System.out.println("Вес коробки №3: " + box3.getWeight());

        // все работает
    }

    // Метод работает с обобщенным типом данных, теперь ему все равно какой массив придет на вход.
    public static <T> void SwapTwoArrayElements(T[] modifiableArray, int elemNum1, int elemNum2) {
        T backupElement = modifiableArray[elemNum1];
        modifiableArray[elemNum1] = modifiableArray[elemNum2];
        modifiableArray[elemNum2] = backupElement;
    }

    // Метод работает с обобщенным типом данных также как и метод swapTwoArrayElements
    public static <T> void convertArrayToArrayList(ArrayList<T> listArray, T[] convertedArray) {
        for (T elem : convertedArray) {
            listArray.add(elem);
        }
    }
}
