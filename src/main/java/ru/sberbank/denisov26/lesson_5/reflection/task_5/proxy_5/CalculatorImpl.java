package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * calc(num - 1);
    }
}

