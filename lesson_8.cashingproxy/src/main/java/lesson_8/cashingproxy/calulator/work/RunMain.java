package lesson_8.cashingproxy.calulator.work;

import java.lang.reflect.Proxy;

public class RunMain {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        ClassLoader classLoader = service.getClass().getClassLoader();
        Class[] interfaces = service.getClass().getInterfaces();
        Service proxyService = (Service) Proxy.newProxyInstance(classLoader, interfaces,
                new ServiceRamCacheInvocationHandler(new ServiceImpl()));
        System.out.println(proxyService.doHardWork(3));
        System.out.println(proxyService.doHardWork(4));
        System.out.println(proxyService.doHardWork(10));
        System.out.println(proxyService.doHardWork(3));
    }
}
