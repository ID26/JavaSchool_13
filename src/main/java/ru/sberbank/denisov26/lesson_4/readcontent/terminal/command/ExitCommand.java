package ru.sberbank.denisov26.lesson_4.readcontent.terminal.command;


import ru.sberbank.denisov26.lesson_4.readcontent.terminal.CashMachine;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.ConsoleHelper;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(/*CashMachine.RESOURCE_PATH + */"exit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String command = ConsoleHelper.readString();
        if (command != null && "y".equals(command.toLowerCase())) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        } else {

        }
    }
}
