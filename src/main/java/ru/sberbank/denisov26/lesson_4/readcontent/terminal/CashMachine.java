package ru.sberbank.denisov26.lesson_4.readcontent.terminal;

import ru.sberbank.denisov26.lesson_4.readcontent.terminal.command.CommandExecutor;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

import java.util.Locale;


public class CashMachine {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        try {
            Operation operation = Operation.LOGIN;
            CommandExecutor.execute(operation);
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException ignored) {
            ConsoleHelper.printExitMessage();
        }
    }
}
