package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - \"Провожающим покинуть вагоны! Поезд отправляется.\"");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " - стоп-кран");
    }
}
