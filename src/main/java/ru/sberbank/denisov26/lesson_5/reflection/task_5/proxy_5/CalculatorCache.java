package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

import java.util.HashMap;
import java.util.Map;

public class CalculatorCache implements Calculator {
    private final Map<Integer, Integer> map = new HashMap<>();
    private Calculator calculator;

    public CalculatorCache(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calc(int arg) {
        if (map.containsKey(arg)) {
            System.out.println("From cache: ");
            return map.get(arg);
        } else {
            int res = calculator.calc(arg);
            map.put(arg, res);
            return res;
        }
    }
}
