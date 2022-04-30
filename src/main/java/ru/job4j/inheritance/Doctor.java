package ru.job4j.inheritance;

public class Doctor extends Profession {
    private String specialty;

    public Doctor(String name, String surname, String education, String birthday, String specialty) {
        super(name, surname, education, birthday);
        this.specialty = specialty;
    }

    public void licence() {
    }
}

