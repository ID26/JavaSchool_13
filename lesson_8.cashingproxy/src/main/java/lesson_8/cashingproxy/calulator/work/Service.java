package lesson_8.cashingproxy.calulator.work;


public interface Service {
    @RamCache
    int doHardWork(int arg);
}
