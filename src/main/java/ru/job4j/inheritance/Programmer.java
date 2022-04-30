package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name, String surname, String education, String birthday, int age, String language) {
        super(name, surname, education, birthday, age);
        this.language = language;
    }

    public void englishLevel() {
    }
}
