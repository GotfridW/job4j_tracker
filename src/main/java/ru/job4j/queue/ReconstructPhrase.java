package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        var builder = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                builder.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        var builder = new StringBuilder();
        var iterator = descendingElements.descendingIterator();
        iterator.forEachRemaining(builder::append);
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
