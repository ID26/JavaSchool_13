package lesson_10.multithreding_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\" +
                "lesson_10.multithreding_1\\src\\main\\resources\\SomeNumbers.txt";
        writeToFileFiftyRandomNumbersBelowFourteen(fileName);
        List<Integer> integers = readToFileFiftyRandomNumbersBelowFourteen(fileName);
        for (Integer integer : integers) {
            new Thread(() -> System.out.println(Thread.currentThread().getName() + ": !" + integer + " = " + new Factorial(integer).toString())).start();
        }
    }


    public static void writeToFileFiftyRandomNumbersBelowFourteen(String fileName) {
        try (FileOutputStream fileWriter = new FileOutputStream(fileName)) {
            for (int i = 0; i < 50; i++) {
                fileWriter.write(new Random().nextInt(13));
            }
        } catch (IOException e) {
            System.err.println("" + e);
        }
    }

    public static List<Integer> readToFileFiftyRandomNumbersBelowFourteen(String fileName) {
        List<Integer> list = new ArrayList<>();
        try (FileInputStream fileReader = new FileInputStream(fileName)) {
            while (fileReader.available() > 0) {
                list.add(fileReader.read());
            }
        } catch (IOException e) {
            System.err.println("" + e);
        }
        return list;
    }

    //    public static void writeToFileFiftyRandomNumbersBelowFourteen(String fileName) {
//        int[] numbers = new int[50];
//        for (int i = 0; i < 50; i++) {
//            numbers[i] = new Random().nextInt(13);
//        }
//        try (FileWriter fileWriter = new FileWriter(fileName)) {
//            String numbersToString = Arrays.toString(numbers);
//            fileWriter.write(numbersToString);
//        } catch (IOException e) {
//            System.err.println("" + e);
//        }
//
//    }
}
