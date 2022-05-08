package ru.job4j.poly;

public class VehiclesUsage {
    public static void main(String[] args) {
        Vehicle doubleDecker = new AutoBus();
        Vehicle ikarus = new AutoBus();
        Vehicle sapsan = new Train();
        Vehicle express = new Train();
        Vehicle airbus = new Plane();
        Vehicle boeing = new Plane();

        Vehicle[] vehicles = new Vehicle[]{doubleDecker, ikarus, sapsan,
                                            express, airbus, boeing};
        for (Vehicle v : vehicles) {
            v.move();
            v.brake();
        }
    }
}
