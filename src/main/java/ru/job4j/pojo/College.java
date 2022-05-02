package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student bill = new Student();
        bill.setFullName("Bill Murray");
        bill.setGroup("JV-31");
        bill.setEntryDate(LocalDate.of(2020, 9, 15));
        System.out.println("Student info:" + "\nFull name: " + bill.getFullName() + ";\nGroup: "
                            + bill.getGroup() + ";\nEntry Date: " + bill.getEntryDate() + ".");
    }
}
