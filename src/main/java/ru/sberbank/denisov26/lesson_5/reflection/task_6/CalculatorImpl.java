package ru.sberbank.denisov26.lesson_5.reflection.task_6;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * calc(num - 1);
    }
}

