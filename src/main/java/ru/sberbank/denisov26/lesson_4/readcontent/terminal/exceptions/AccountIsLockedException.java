package ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions;

public class AccountIsLockedException extends InterruptOperationException {
    public AccountIsLockedException(long mSec) {
        System.out.printf("Account is locked, wait %d seconds", mSec/1000);
    }
}
