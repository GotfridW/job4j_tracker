package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student bill = new Student();
        bill.setFullName("Bill Murray");
        bill.setGroup("JV-31");
        bill.setEntryDate(LocalDate.of(2020, 9, 15));
        String ln = System.lineSeparator();
        System.out.println("Student info:" + ln + "Full name: " + bill.getFullName() + ";" + ln + "Group: "
                            + bill.getGroup() + ";" + ln + "Entry Date: " + bill.getEntryDate() + ".");
    }
}
