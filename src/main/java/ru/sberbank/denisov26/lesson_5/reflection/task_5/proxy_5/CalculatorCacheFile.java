package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CalculatorCacheFile implements Calculator {
    private final String fileStorage = "src\\main\\resources\\FileStorage.txt";
    File file;
    private Calculator calculator;

    public CalculatorCacheFile(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    @Cache
    public int calc(int arg) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try (FileReader reader = new FileReader(fileStorage);
             FileWriter writer = new FileWriter(fileStorage)) {
//            if (file.containsKey(arg)) {
//                System.out.println("From cacheFile : ");
//                return map.get(arg);
//            } else {
//
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
