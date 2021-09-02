package ru.sberbank.denisov26.lesson_5.reflection.task_6;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //Создаем оригинальный объект with @metric
        CalculatorImpl calculator = new CalculatorImpl();

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader calcClassLoader = calculator.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = calculator.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        Calculator proxyCalc = (Calculator) Proxy.newProxyInstance(calcClassLoader, interfaces, new CalculatorImplInvocationHandler(calculator));

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        System.out.println(proxyCalc.calc(13));
    }
}
