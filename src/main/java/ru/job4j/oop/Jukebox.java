package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже пешеходы по лужам" + "\n" + "И текут по асфальту рекой.");
        } else if (position == 2) {
            System.out.println("Спяяят устааалые игрушки, книжки спяяят" + "\n" + "Оодеяяла и подуушки ждут ребяяят");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox play = new Jukebox();
        play.music(1);
        play.music(2);
        play.music(5);
    }
}
