package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CalculatorImplInvocationHandler implements InvocationHandler {
    private Calculator calculator;
    private final Map<Object, Object> cacheMap = new HashMap<>();


    public CalculatorImplInvocationHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    // Писал сам, поэтому не так красиво как в учебном материале,
    // но в нем без проблем разобрался.
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(calculator, args);
        }
        System.out.println("Method with annotation @Cache");
        Object value;
        Object key = args[0];
        if (!cacheMap.containsKey(key)) {
            value = method.invoke(calculator, args);
            cacheMap.put(key, value);
            System.out.println("Put in cache");
        } else {
            System.out.println("Get from cache");
            value = cacheMap.get(key);
        }
        return value;
    }
}
