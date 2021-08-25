package ru.sberbank.denisov26.lesson_4.readcontent.terminal;

public class TerminalImpl implements Terminal {

    public static void main(String[] args) {
        Operation operation = ConsoleHelper.askOperation();
    }

    @Override
    public String checkTheAccountStatus(Operation operation) {
        return null;
    }

    @Override
    public String depositOrWithdrawMoney(Operation operation) {
        return null;
    }
}
