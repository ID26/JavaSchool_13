package lesson_8.cashingproxy.calulator.work;

import lesson_8.cashingproxy.calulator.garbage.FileCache;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ServiceRamCacheInvocationHandler implements InvocationHandler {
    private Service service;
    private final Map<Object, Object> cacheMap = new HashMap<>();
    private static final String FILE_SERIALISATION = "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\lesson_8.cashingproxy\\src\\main\\resources\\cash.ser";

    public ServiceRamCacheInvocationHandler(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (!method.isAnnotationPresent(RamCache.class)) {
            return method.invoke(service, args);
        }
        System.out.println("Method with annotation @RamCache");
        Object value;
        Object key = args[0];
        if (!cacheMap.containsKey(key)) {
            value = method.invoke(service, args);
            cacheMap.put(key, value);
            System.out.println("Put in cache");
        } else {
            System.out.println("Get from cache");
            value = cacheMap.get(key);
        }

        Object object = method.invoke(service, args);
        if (method.isAnnotationPresent(FileCache.class)) {
            try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(FILE_SERIALISATION))) {
                System.out.println(object.getClass());
            }

        }
        return value;
    }
}
