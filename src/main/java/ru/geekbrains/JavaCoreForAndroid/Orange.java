package ru.geekbrains.JavaCoreForAndroid;

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
public class Orange extends Fruit{
    // данный конструктор оставил на случай если захочу менять вес апельсина при создании
    // так как класс Fruit абстрактный
    // так как класс Fruit абстрактный IDE сразу заставляет переопределить конструктор...
    public Orange(float weight) {
        super(weight);
    }

    public Orange() {
        super(1.5f); // согласно задания вес одного апельсина 1.5f
    }

}
