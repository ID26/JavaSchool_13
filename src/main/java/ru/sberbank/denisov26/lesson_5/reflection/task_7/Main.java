package ru.sberbank.denisov26.lesson_5.reflection.task_7;

public class Main {
    public static void main(String[] args) {
        From from = new From("string from", 7);
        To to = new To();
        BeanUtils.assign(to, from);
        System.out.println(to);
    }
}
