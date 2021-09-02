package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class[] interfaces = calculator.getClass().getInterfaces();
//        Calculator proxyCalc = (Calculator) Proxy.newProxyInstance(classLoader, interfaces,
//                new CalculatorImplInvocationHandler(new CalculatorImpl()));
//        System.out.println(proxyCalc.calc(7));
//        System.out.println(proxyCalc.calc(6));
//        System.out.println(proxyCalc.calc(5));
//        System.out.println(proxyCalc.calc(7));
//        System.out.println(proxyCalc.calc(5));
//        System.out.println(proxyCalc.calc(5));

        Calculator proxyCalcFile = (Calculator) Proxy.newProxyInstance(classLoader, interfaces,
                new CalculatorImplInvocationHandlerFile(new CalculatorImpl()));
        System.out.println(proxyCalcFile.calc(2));
        System.out.println(proxyCalcFile.calc(4));
        System.out.println(proxyCalcFile.calc(13));
        System.out.println(proxyCalcFile.calc(6));
        System.out.println(proxyCalcFile.calc(4));
        System.out.println(proxyCalcFile.calc(13));
    }
}
