package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorCache(new CalculatorImpl());
        System.out.println(calculator.calc(7));
        System.out.println(calculator.calc(6));
        System.out.println(calculator.calc(5));
        System.out.println(calculator.calc(7));
        System.out.println(calculator.calc(6));
        System.out.println(calculator.calc(5));
    }
}
