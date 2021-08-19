package ru.sberbank.denisov26.lesson_2.filetocollection;

import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static <T> void printList(List<T> list) {
        list.stream().forEach(System.out::println);
    }
}
