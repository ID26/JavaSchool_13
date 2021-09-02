package ru.sberbank.denisov26.lesson_5.reflection.task_1;


public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * calc(num - 1);
    }

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.calc(13));
        System.out.println(calculator.calc(-13));
        System.out.println(calculator.calc(1));
        System.out.println(calculator.calc(0));
        System.out.println(calculator.calc(2));
        System.out.println(calculator.calc(3));
    }
}
