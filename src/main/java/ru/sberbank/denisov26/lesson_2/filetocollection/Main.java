package ru.sberbank.denisov26.lesson_2.filetocollection;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static File file = new File(
            "src/main/resources/Пушкин.txt");

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(" ");
            }
            String[] result = builder.toString().replaceAll(
                    "[^а-яА-Я ][^\\S\\r\\n]", "").trim().split(" ");
//            Arrays.stream(result).forEach(System.out::println);
            System.out.printf("Задание 1: Подсчитайте количество различных слов в файле. " +
                    "Количество различных слов в файле = %d", new DifferentWorld(result).quantityDifferentWorld());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
