package ru.geekbrains.JavaCoreForAndroid;

/**
 * Сourse: java core for android
 * Faculty of Geek University Android Development
 *
 * @Author Student Dmitry Veremeenko aka StDimensiy
 * Group 24.12.2020
 * <p>
 * HomeWork for lesson 11
 * Created 04.02.2021
 * v2.0
 */
public class Apple extends Fruit{
    // данный конструктор оставил на случай если захочу менять вес яблока при создании
    // так как класс Fruit абстрактный
    // так как класс Fruit абстрактный IDE сразу заставляет переопределить конструктор...
    public Apple(float weight) {
        super(weight);
    }
    public Apple() {
        super(1.0f); // согласно задания вес одного яблока 1.0f
    }
}
