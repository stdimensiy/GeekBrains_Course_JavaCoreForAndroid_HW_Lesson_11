package ru.geekbrains.JavaCoreForAndroid;

import java.util.ArrayList;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson1
 * Created 04.02.2021
 * v2.0
 */
public class Box {
    // У каждой новой создаваемой коробки есть предназначение (только для конкретного типа фруктов)
    // для хранения фруктов внутри коробки можно использовать ArrayList
    private ArrayList<Fruit> product = new ArrayList<>(); // пока оставил класс родителя в АррейЛисте потом посмотрб смогу лия чтонить с ним сделать

    // считать коробки нам пока ненужно поэтому статических переменных не будет


    public Box() {
        ArrayList<Fruit> product = new ArrayList<>();
    }

    // метод возвращает общий вес коробки
    public double getWeight() {
        // Так как по условиям задания все фрукты имеют одинаковый вес ответ очень простой,
        // однако я подумал о расширяемом методе и выполнил его чуть сложнее.
        double sumWeightProducts = 0.0f;
        for (Fruit e : product) {
            sumWeightProducts += e.getWeight();
        }
        return sumWeightProducts;
    }

    // Метод создан для предоставления доступа к ArrayList продуктов которые кв коробке (для безопасности)
    public ArrayList<Fruit> getProduct() {
        return product;
    }

    // метод добавляет в коробку один элемент
    public void add(Fruit fruit) {
        if (product.size() > 1) {
            if (isProductsComparable(fruit)) {
                throw new BoxCustomException("Внимание! Смешивать товары запрещено, используйте другой товар или коробку!");
            }
        }
        product.add(0, fruit);
    }

    // метод сравнения двух коробок по весу
    public boolean compare(Box other) {
        // согласно условия результат работы данного метода true - если массы равны false - если не равны.
        return Math.abs(getWeight() - other.getWeight()) < 0.0001; // пример взят из урока для устранения неточности расчета
    }

    // метод позволяет достать из коробки 1 элемент (без привязки куда его затем класть)
    public void removeSingleItem() {

    }

    // метод позволяет перекладывать из коробки 1 в коробку 2 заданное количество элементов
    // (имеет защиту - проверяет возможность перекладывания, если условие false элемент из коробки не уйдет)
    // метод выполняет задачу поэлементно (можно сделать сразу много или все методом addAll)
    public void shiftSingleItem(Box box2) throws BoxCustomException {
        // цикл foreach не подходит для пересыпания с одновременным контролем и удалением перекладываемых элементов
        // проверка на сопоставимость наполнения коробок
        if (isProductsComparable(box2)) {
            throw new BoxCustomException("Внимание! Смешивать товары запрещено, используйте другой товар или коробку!");
        }
        for (int i = product.size() - 1; i >= 0; i--) {
            box2.getProduct().add(product.get(i));
            product.remove(i);
        }
    }

    // метод который позволяет определить сопоставимы ли продукты по типу в коробке и вне ее.
    public boolean isProductsComparable(Box otherBox) {
        return product.get(0).getClass() != otherBox.getProduct().get(0).getClass();
    }

    // Перегруженный метод (мне понравилось ими пользоваться)
    public boolean isProductsComparable(Fruit fruit) {
        return product.get(0).getClass() != fruit.getClass();
    }


}
