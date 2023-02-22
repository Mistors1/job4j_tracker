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
        String rsl = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                String b = String.valueOf(evenElements.pop());
                evenElements.addLast((char) i);
                stringBuilder.append(b);
                rsl = String.valueOf(stringBuilder);
            } else {
                evenElements.remove();
                evenElements.addLast('l');
            }

        }
        return rsl;
    }

    private String getDescendingElements() {
        String rsl = null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            String b = String.valueOf(descendingElements.pollLast());
            descendingElements.addFirst((char) i);
            stringBuilder.append(b);
            rsl = String.valueOf(stringBuilder);
        }
        return rsl;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}