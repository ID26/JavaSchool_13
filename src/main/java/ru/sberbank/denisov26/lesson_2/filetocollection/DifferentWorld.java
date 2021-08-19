package ru.sberbank.denisov26.lesson_2.filetocollection;

import java.util.*;

public class DifferentWorld {
    private String[] words;
    public DifferentWorld(String[] result) {
        words = result;
    }

    public HashMap<String, Integer> quantitySameCase() {
        HashMap<String, Integer> res = new HashMap<>();
        for (String s : words) {
            if (res.containsKey(s)) {
                int value = res.get(s);
                res.put(s, ++value);
            } else {
                res.put(s, 1);
            }
        }
        return res;
    }

    public int quantityDifferentWorld() {
        return getWordsSet().size();
    }

    public ArrayList<String> sortedSetByFirstLengthSecondText() {
        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length() - o2.length() == 0) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        };

        ArrayList<String> list = new ArrayList<>(getWordsSet());
        Collections.sort(list, comparator);
        return list;
    }

    public Set<String> getWordsSet() {
        return new HashSet<>(Arrays.asList(words));
    }
}
