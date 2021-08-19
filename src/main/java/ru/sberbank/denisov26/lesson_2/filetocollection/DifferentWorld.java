package ru.sberbank.denisov26.lesson_2.filetocollection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DifferentWorld {
    private Set<String> words;
    public DifferentWorld(String[] result) {
        words = new HashSet<>(Arrays.asList(result));
    }

    public int quantityDifferentWorld() {
        return words.size();
    }

    public Set<String> getWords() {
        return words;
    }
}
