package ru.sberbank.denisov26.lesson_5.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GetAllMethodsClass {

    public static Set<Method> getAllMethodsIncludingInheritedOnes(Class<?> clazz) {
        Set<Method> methods = new HashSet<>(Arrays.asList(clazz.getMethods()));
        methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        return methods;
    }

    public static void main(String[] args) {
//        Set<Method> methods = GetAllMethodsClass.getAllMethodsIncludingInheritedOnes(Integer.class);
//        methods.stream().forEach(s -> System.out.println(s));
//        System.out.println(methods.size());
//
//        System.out.println("\n******************************************************\n");
//        printAllMethodsIncludingInheritedAndPrivate(Integer.class);
//
//        System.out.println("\n******************************************************\n");
//        printAllGetters(Integer.class);

        System.out.println("\n******************************************************\n");
        checkAllStringConstantHaveMeanEqualsName(SomeClass.class);

//        System.out.println("\n******************************************************\n");
//        System.out.println("\n******************************************************\n");
//        System.out.println("\n******************************************************\n");
//        System.out.println("\n******************************************************\n");
//        System.out.println("\n******************************************************\n");
//        System.out.println("\n******************************************************\n");
    }

    private static void checkAllStringConstantHaveMeanEqualsName(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field + " " + field.getType() + " " + field.getModifiers());
            if (field.getType() == String.class ) {
               // System.out.println(field);
            }
        }

    }

    private static void printAllGetters(Class<?> clazz) {
        for (Method method : clazz.getMethods())
        {
            if (method.getName().matches("get\\w*")) {
                System.out.println("Public method found: " +  method.toString());
            }
        }
    }

    private static void printAllMethodsIncludingInheritedAndPrivate(Class clazz) {
        int count = 0;
        while (clazz != null) {
            Arrays.stream(clazz.getDeclaredMethods()).forEach(System.out::println);
            count += clazz.getDeclaredMethods().length;
            clazz = clazz.getSuperclass();
        }
        System.out.println(count);
    }
}
