package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        boolean go = false;
    }

    @Override
    public void passenger(int passengers) {
        boolean boarding = passengers > 0;
    }

    @Override
    public int refuel(int fuel) {
        return 50 * fuel;
    }
}
