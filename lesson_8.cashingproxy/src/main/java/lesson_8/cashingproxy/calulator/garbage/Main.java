package lesson_8.cashingproxy.calulator.garbage;

import lesson_8.cashingproxy.calulator.work.Service;
import lesson_8.cashingproxy.calulator.work.ServiceImpl;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        //Создаем оригинальный объект with @metric
        ServiceImpl calculator = new ServiceImpl();

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader calcClassLoader = calculator.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = calculator.getClass().getInterfaces();

        //Создаем прокси нашего объекта vasia
        Service proxyCalc = (Service) Proxy.newProxyInstance(calcClassLoader, interfaces, new ServiceImplInvocationHandler(calculator));

        //Вызываем у прокси объекта один из методов нашего оригинального объекта
        System.out.println(proxyCalc.doHardWork(13));
    }
}
