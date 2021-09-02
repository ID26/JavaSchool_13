package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

public interface Calculator {
    @Cache
    @CacheFile
    int calc(int arg);
}
