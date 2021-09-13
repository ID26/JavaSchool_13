package lesson_8.cashingproxy.calulator.pac;


import java.io.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class ServiceCacheInvocationHandler implements InvocationHandler {
    private Service service;
    private final Map<Object, Object> cacheMap = new HashMap<>();
    private String directory;

    public ServiceCacheInvocationHandler(Service service, String directory) {
        this.service = service;
        this.directory = directory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(null)) {
            return method.invoke(service, args);
        }

        System.out.println("Method with annotation @Cache");
        Cache cache = method.getAnnotation(Cache.class);
        if (cache.cacheType() == CacheType.IN_MEMORY) {
            System.out.println("Memory");
            return cashStorage(cache, method, args);
        }
        if (cache.cacheType() == CacheType.FILE) {
            String name = !cache.fileNamePrefix().equalsIgnoreCase("methodName") ? cache.fileNamePrefix() : method.getName();
            String fileName = String.format("%s\\%s.ser", directory, name);
            System.out.println("File");
            Object object;

            if (cacheMap.containsKey(fileName)) {
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
                    object = inputStream.readObject();
                    System.out.println("From file");
                }
            } else {
                try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    object = method.invoke(service, args);
                    outputStream.writeObject(object);
                }
            }
            cacheMap.put(fileName, object);

            return object;
        }
        return method.invoke(service, args);
    }

    public Object cashStorage(Cache cache, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        Object value;
        String key = null;
        Class[] classes = cache.identity();
        for (Class aClass : classes) {
            for (Object o : args) {
                if(o.getClass() == aClass) {
                    key += o;
                }
            }
        }
        if (!cacheMap.containsKey(key)) {
            value = method.invoke(service, args);
            cacheMap.put(key, value);
            System.out.println("Put to cache");
        } else {
            System.out.println("Get from cache");
            value = cacheMap.get(key);
        }
        return value;
    }
}
