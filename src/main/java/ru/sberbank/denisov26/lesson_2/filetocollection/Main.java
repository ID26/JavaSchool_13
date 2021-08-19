package ru.sberbank.denisov26.lesson_2.filetocollection;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/main/resources/Пушкин.txt");
        FileContent content = new FileContent(file);

        ConsoleHelper.printMessage(String.format(
                "Количество различных слов в файле = %d\n\r",
                new DifferentWorld(content.getAllLineAsString()).quantityDifferentWorld()));

        ConsoleHelper.printMessage("Список различных слов файла, " +
                "отсортированный по возрастанию их длины, потом по тексту: \n\r");
        new DifferentWorld(content.getAllLineAsString())
                .sortedSetByFirstLengthSecondText().forEach(s -> System.out.print(s + " "));

        ConsoleHelper.printMessage("Список количесва присутствия каждого из слов, " +
                "встречающихся в файле: \n\r");
        new DifferentWorld(content.getAllLineAsString())
                .quantitySameCase().forEach((s, v) -> System.out.println(s + " : " + v));

        ConsoleHelper.printMessage("\n\rRevers line from file: ");
        ConsoleHelper.printList(content.getReversLine());

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                ConsoleHelper.printMessage("\n\rEnter string number: ");
                try {
                    String usersClick = bufferedReader.readLine();
                    if ("exit".equalsIgnoreCase(usersClick)) {
                        return; }
                    int lineNumber = Integer.parseInt(usersClick);
                    if (lineNumber >= content.getFileContentLines().size() + 1 || lineNumber <= 0) {
                        ConsoleHelper.printMessage(String.format(
                                "The do't contain requested line number, " +
                                        "enter number from 1 to %d", content.getFileContentLines().size()));
                        continue;
                    } else {
                        ConsoleHelper.printMessage(content.getLineByNumber(--lineNumber));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.printMessage("Incorrect number");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
