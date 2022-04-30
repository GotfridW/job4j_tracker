package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String skills;

    public Surgeon(String name, String surname, String education, String birthday, String specialty, String skills) {
        super(name, surname, education, birthday, specialty);
        this.skills = skills;
    }

    public void salary() {
    }
}
