package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    Six, Seven, Eight, Nine,
    Ten, Jack, Queen, King, Ace
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + value + " of "
                + suit + '}';
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(stream -> Stream.of(Value.values())
                        .map(value -> new Card(stream, value)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
