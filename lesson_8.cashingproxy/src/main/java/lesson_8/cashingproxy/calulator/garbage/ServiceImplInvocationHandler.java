package lesson_8.cashingproxy.calulator.garbage;

import lesson_8.cashingproxy.calulator.work.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceImplInvocationHandler implements InvocationHandler {
    Service calculator;

    public ServiceImplInvocationHandler(Service calculator) {
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
