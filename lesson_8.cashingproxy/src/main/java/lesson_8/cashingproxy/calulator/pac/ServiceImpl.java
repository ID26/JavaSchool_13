package lesson_8.cashingproxy.calulator.pac;

public class ServiceImpl implements Service {
    @Override
    public double doHardWork(String s, Integer i) {
        return (double) s.length()/i;
    }
}
