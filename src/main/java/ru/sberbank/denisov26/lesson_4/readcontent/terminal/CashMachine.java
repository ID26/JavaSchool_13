package ru.sberbank.denisov26.lesson_4.readcontent.terminal;

import ru.sberbank.denisov26.lesson_4.readcontent.terminal.command.CommandExecutor;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.command.LoginCommand;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

import java.util.Locale;


public class CashMachine implements Terminal {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";


    public static void main(String[] args) {

//        try {
//            ConsoleHelper.readPin();
//        } catch (InterruptOperationException e) {
//            e.printStackTrace();
//        }
//        System.out.println(RESOURCE_PATH);
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



    @Override
    public String checkTheAccountStatus(Operation operation) {
        return null;
    }

    @Override
    public String depositMoney(Operation operation) {
        return null;
    }

    @Override
    public String withdrawMoney(Operation operation) {
        return null;
    }

}
