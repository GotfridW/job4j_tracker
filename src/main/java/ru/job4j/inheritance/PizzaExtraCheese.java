package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    @Override
    public String name() {
        String name = " + extra cheese";
        return super.name() + name;
    }
}
