package lesson_8.cashingproxy.calulator.work;

import lesson_8.cashingproxy.calulator.work.Service;

public class ServiceImpl implements Service {
    @Override
    public int doHardWork(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * doHardWork(num - 1);
    }
}

