package lesson_8.cashingproxy.calulator.pac;

import java.lang.reflect.Proxy;

public class RunMain {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        ClassLoader classLoader = service.getClass().getClassLoader();
        Class[] interfaces = service.getClass().getInterfaces();
        ServiceCacheInvocationHandler invocationHandler = new ServiceCacheInvocationHandler(new ServiceImpl(),
                "C:\\Users\\Иван\\YandexDisk\\JavaSchool_13\\lesson_8.cashingproxy\\src\\main\\resources");
        Service proxyService = (Service) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        System.out.println(proxyService.doHardWork("mama washing window",3));
        System.out.println(proxyService.doHardWork("Peter and Wolf",4));
        System.out.println(proxyService.doHardWork("Timur and his team",10));
        System.out.println(proxyService.doHardWork("Heat stone",3));
        System.out.println(proxyService.doHardWork("timur and his team",10));
        System.out.println(proxyService.doHardWork("peter and Wolf",4));
        System.out.println(proxyService.doHardWork("mama washing window",3));

    }
}
