package ru.job4j.poly;

public class AutoBus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - Сцепление - передача - педаль в пол - движ");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " - Педаль тормоза");

    }
}
