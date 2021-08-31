package ru.sberbank.denisov26.lesson_5.reflection;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        if (number == 1) {
            return 1;
        }
        return number *= calc(number - 1);
    }

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.calc(13));
    }
}
