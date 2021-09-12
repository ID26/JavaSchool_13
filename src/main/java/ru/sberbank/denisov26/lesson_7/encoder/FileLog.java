package ru.sberbank.denisov26.lesson_7.encoder;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileLog {
    public static void writeToFile(byte [] bytes) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\src\\main\\resources/result.txt", true);
        outputStream.write(bytes);
        outputStream.write("\r\n\n\n".getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
