package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Game 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "First player" : "Second player";
            System.out.println(player + ", enter a number from 1 to 3");
            int matches = Integer.parseInt(input.nextLine());
            if (matches < 1 || matches > 3) {
                System.out.println("Incorrect number! The number should be from 1 to 3!");
            } else if (matches > count) {
                System.out.println("There are only " + count + " matches!");
            } else {
                turn = !turn;
                count -= matches;
                System.out.println("Matches left: " + count);
            }
        }
        System.out.println(!turn ? "First player wins" : "Second player wins");
    }
}
