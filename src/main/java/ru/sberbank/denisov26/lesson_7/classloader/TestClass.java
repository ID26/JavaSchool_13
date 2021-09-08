package ru.sberbank.denisov26.lesson_7.classloader;

import ru.sberbank.denisov26.lesson_2.carfleet.Car;

import java.net.URLClassLoader;

public class TestClass {
    public static void main(String[] args) {
        Car car = new Car("fff", "ggg");

        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(car.getClass().getClassLoader());
        System.out.println(TestClass.class.getClassLoader());
        Integer i = new Integer(5);
        System.out.println(Integer.class.getClassLoader());
        System.out.println(i=6);
//        System.out.println(Class.forName("Integer", true, new URLClassLoader("", URLClassLoader.newInstance({"",""}))));
    }
}


