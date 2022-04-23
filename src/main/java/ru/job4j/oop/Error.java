package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Errors found: " + active);
        System.out.println("Errors in total: " + status);
        System.out.println("Details: " + message + "\n");
    }

    public static void main(String[] args) {
        Error first = new Error();
        Error second = new Error(true, 5, "Files not found");
        Error third = new Error(false, 0, "Errors not found");
        Error fourth = new Error(true, 3, "Inappropriate value");
        first.printInfo();
        second.printInfo();
        third.printInfo();
        fourth.printInfo();
    }
}
