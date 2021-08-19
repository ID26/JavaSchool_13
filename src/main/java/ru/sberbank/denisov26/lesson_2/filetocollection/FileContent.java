package ru.sberbank.denisov26.lesson_2.filetocollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileContent {
    private File file;

    public FileContent(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String[] getAllLineAsString() {
        StringBuilder builder = new StringBuilder();
        for (String s : getFileContentLines()) {
            builder.append(s).append(" ");
        }
        return  builder.toString().replaceAll(
                "[^а-яА-Я]\\s+", " ").trim().split("\\s");
    }

    public String getLineByNumber(int numberLine) {
        return getFileContentLines().get(numberLine);
    }

    public List<String> getFileContentLines() {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches("\\W+")) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getReversLine() {
        List<String> reversLine = getFileContentLines();
        Collections.reverse(reversLine);
        return reversLine;
    }
}
