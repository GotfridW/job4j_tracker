package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item {

    public static void main(String[] args) {
        StartUI item = new StartUI();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        LocalDateTime dateTime = item.getCreated();
        System.out.println(dateTime.format(formatter));
    }
}
