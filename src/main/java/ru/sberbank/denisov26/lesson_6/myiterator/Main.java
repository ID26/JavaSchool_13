package ru.sberbank.denisov26.lesson_6.myiterator;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer [] arr = new Integer[50];
        fill(arr);
        for (Integer s: arr) {
            System.out.println(s);
        }
        MyIterator<String> iterator = new MyIterator(arr);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }

    private static void fill(Integer[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = random.nextInt(99) + 1;
        }
    }
}
