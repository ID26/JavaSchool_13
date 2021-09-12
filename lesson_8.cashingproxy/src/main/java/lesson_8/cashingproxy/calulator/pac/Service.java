package lesson_8.cashingproxy.calulator.pac;

public interface Service {
    @Cache(fileNamePrefix = "myData")
    double doHardWork(String s, Integer i);
}
