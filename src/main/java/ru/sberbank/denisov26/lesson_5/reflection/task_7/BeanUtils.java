package ru.sberbank.denisov26.lesson_5.reflection.task_7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.Arrays;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */

    public static void assign(Object to, Object from) {
        for (Method getter : from.getClass().getDeclaredMethods()) {
            if (getter.getName().startsWith("get")) {
      //          System.out.println(getter.getName().substring(3));
                for (Method setter : to.getClass().getDeclaredMethods()) {
                    if (setter.getName().startsWith("set")) {
      //                  System.out.println(setter.getName().substring(3));
                        if (getter.getName().substring(3).equalsIgnoreCase(setter.getName().substring(3))) {
//                            System.out.println(getter.getName().substring(3).equalsIgnoreCase(setter.getName().substring(3)));
                            System.out.println(getter.getName().substring(3));
                            try {
                                setter.invoke(to, getter.invoke(from));
//                                throw new IllegalAccessException();
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                System.err.println(new StringBuilder("Error. ").append(e).toString());;
                            }
                        }
                    }
                }

            }
        }
    }
}
