package lesson_8.cashingproxy.calulator.garbage;

import lesson_8.cashingproxy.calulator.work.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ServiceRamCache implements Service, Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<Integer, Integer> map = new HashMap<>();
    private Service service;

    public ServiceRamCache(Service service) {
        this.service = service;
    }

    @Override
    public int doHardWork(int arg) {
        if (map.containsKey(arg)) {
            System.out.println("From cache: ");
            return map.get(arg);
        } else {
            int res = service.doHardWork(arg);
            map.put(arg, res);
            return res;
        }
    }
}
