package ru.sberbank.denisov26.lesson_3.generics;

import ru.sberbank.denisov26.lesson_3.generics.CountMap;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<K> implements CountMap<K> {

    private final Map<K, Integer> map = new HashMap<>();

    // добавляет элемент в этот контейнер.
    @Override
    public void add(K k) {
        if (map.containsKey(k)) {
            int count = map.get(k);
            map.put(k, ++count);
        } else {
            map.put(k, 1);
        }
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(K k) {
        if (!map.containsKey(k)) {
            return 0;
        }
        return map.get(k);
    }

    //Удаляет элемент из контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(K k) {
        Integer count = null;
        if (map.containsKey(k)) {
            count = map.get(k);
            map.remove(k);
        }
        return count;
    }

    //количество разных элементов
    @Override
    public int size() {
        return map.size();
    }

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    @Override
    public void addAll(CountMap<K> source) {
        if (source == null) {
            return;
        }
        for (Object o : source.toMap().keySet()) {
            K key = (K) o;
            if (map.containsKey(key)) {
                int count = map.get(key) + (int) source.toMap().get(key);
                map.put(key, count);
            } else {
                map.put(key, 1);
            }
        }
    }

//    @Override
//    public void addAll(CountMap source) {
//        for (Object key: source.toMap().keySet()) {
//            Integer count;
//            if((count = map.get(key)) == null) {
//                count = 0;
//            }
//            map.put((K) key, source.getCount(key) + count);
//        }
//    }

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    @Override
    public Map toMap() {
        return map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map destination) {
        for (K key: map.keySet()) {
            destination.put(key, map.get(key));
        }
    }
}
