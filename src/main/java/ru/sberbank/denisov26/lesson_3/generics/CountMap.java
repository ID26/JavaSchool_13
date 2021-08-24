package ru.sberbank.denisov26.lesson_3.generics;

import java.util.HashMap;
import java.util.Map;

public interface CountMap<K> {
    // добавляет элемент в этот контейнер.
    void add(K k);

    //Возвращает количество добавлений данного элемента
    int getCount(K k);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(K k);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    void addAll(CountMap<K> source);

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    Map toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map  destination);

    public static void main(String[] args) {
        CountMap map = new CountMapImpl();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        map.addAll(map);

        System.out.println("Map size is: " + map.size());
        System.out.println("Remove 10 from map, quantity added same elements: " + map.remove(10));
        System.out.println("Map size is: " + map.size());


        int count = map.getCount(5); // 2
        int count1 = map.getCount(6); // 1
        int count2 = map.getCount(10); // 3

        System.out.println(count + " " + count1 + " " + count2);

        Map<Integer, Integer> dest = new HashMap<>();
        map.toMap(dest);

        for (Integer integer : dest.keySet()) {
            System.out.println(integer + " " + dest.get(integer));
        }


    }
}
