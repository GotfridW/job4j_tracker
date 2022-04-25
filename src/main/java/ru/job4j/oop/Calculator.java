package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int num) {
        return x + num;
    }

    public int multiply(int num) {
        return x * num;
    }

    public static int minus(int num) {
        return num - x;
    }

    public int divide(int num) {
        return num / x;
    }

    public int sumAllOperation(int num) {
        return sum(num) + multiply(num) + minus(num) + divide(num);
    }

    public static void main(String[] args) {
        System.out.println(sum(10));
        Calculator calculator = new Calculator();
        System.out.println(calculator.multiply(5));
        System.out.println(minus(15));
        System.out.println(calculator.divide(25));
        System.out.println(calculator.sumAllOperation(20));
    }
}
