package ru.sberbank.denisov26.lesson_7.encoder;

import java.io.IOException;

public class ClassForEncoding {
    public static void main(String[] args) {
        String s = "Mother wash window!!!";
        try {
            FileLog.writeToFile(s.getBytes());
        } catch (IOException e) {
            System.err.println(e);
        }
        System.out.println(s);
    }
}
