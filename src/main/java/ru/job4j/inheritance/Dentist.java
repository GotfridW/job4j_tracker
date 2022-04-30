package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int experience;

    public Dentist(String name, String surname, String education, String birthday, String specialty, int experience) {
        super(name, surname, education, birthday, specialty);
        this.experience = experience;
    }

    public void worksWithChildren() {
    }
}
