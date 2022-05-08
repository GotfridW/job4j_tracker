package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - Тяга на полную - взлёт");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " - Обратная тяга/стояночный тормоз");
    }
}
