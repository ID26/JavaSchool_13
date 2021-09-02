package ru.sberbank.denisov26.lesson_5.reflection.task_6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorImplInvocationHandler implements InvocationHandler {
    Calculator calculator;

    public CalculatorImplInvocationHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();
        Object res = method.invoke(calculator, args);
        long timeExecution = System.nanoTime() - start;

        if (method.isAnnotationPresent(Metric.class)) {
            System.out.println(String.format("Method execution time: %d nanoseconds.", timeExecution));
        }
        return res;
    }
}
