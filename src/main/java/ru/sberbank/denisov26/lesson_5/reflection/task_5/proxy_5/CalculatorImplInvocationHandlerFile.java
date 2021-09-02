package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CalculatorImplInvocationHandlerFile implements InvocationHandler {
    private final Object object;
    private final Map<Object, Object> cacheFile = new HashMap<>();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final File file = new File("C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\src\\main\\resources\\FileStorage.txt");

    public CalculatorImplInvocationHandlerFile(Object object) {
        this.object = object;

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Check path. ");
                e.getCause();
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(CacheFile.class)) {
            return invoke(method, args);
        }
//        LRUCache<Object, Object> lruCache;
        Element element;
        List<Object> key = new ArrayList<>();
        Object value;

        try (BufferedReader reader = new  BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter(file)) {
            String line;
            key.addAll(key(method, args));
            while ((line = reader.readLine()) != null) {
//                lruCache = GSON.fromJson(line, LRUCache.class);
                element = GSON.fromJson(line, Element.class);
//                System.out.println(element.getKey() + " " + element.getValue());
                if (element.getKey().equals(key)) {
                    return element.getValue();
                }
            }
//            lruCache = new LRUCache(1000);
//            lruCache = new LRUCache<>(key, invoke(method, args));
            value = invoke(method, args);
            element = new Element(key, value);


//            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//            String json = GSON.toJson(element);
//            writer.write(json);
        }
        return value;
    }

    private List<Object> key(Method method, Object[] args)  {
        List<Object> key = new ArrayList<>();
//        в лист объектов добавляем метод
        key.add(method);
//        в лист обектов добавляем метод все аргументы,
//        то есть ключем является список объектов из метода и его аргументов
        key.addAll(Arrays.asList(args));
//        возвращаем {метод интерфейса, ... аргументы}
        return key;
    }

    private Object invoke(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(object, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Impossible", e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
