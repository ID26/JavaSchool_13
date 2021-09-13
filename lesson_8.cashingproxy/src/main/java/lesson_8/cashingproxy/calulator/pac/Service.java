package lesson_8.cashingproxy.calulator.pac;

public interface Service {
//
    @Cache(cacheType = CacheType.FILE/*, fileNamePrefix = "myData"/*, identity = {String.class}*/)
    double doHardWork(String s, Integer i);
}
