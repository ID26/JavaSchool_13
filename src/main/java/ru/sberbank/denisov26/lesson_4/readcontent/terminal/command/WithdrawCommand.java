package ru.sberbank.denisov26.lesson_4.readcontent.terminal.command;


import ru.sberbank.denisov26.lesson_4.readcontent.terminal.ConsoleHelper;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.CurrencyManipulator;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.CurrencyManipulatorFactory;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle("withdraw");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                String s = ConsoleHelper.readString();
                if (s == null) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                } else {
                    try {
                        int amount = Integer.parseInt(s);
                        if (amount % 100 != 0) {
                            throw new NumberFormatException();
                        }
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if (isAmountAvailable) {
                            Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                            for (Integer item : denominations.keySet()) {
                                ConsoleHelper.writeMessage("\t" + item + " - " + denominations.get(item));
                            }

                            ConsoleHelper.writeMessage(String.format("%d %s was withdrawn successfully", amount, currencyCode));
                            break;
                        } else {
                            ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                        }
                    } catch (NumberFormatException e) {
                        ConsoleHelper.writeMessage("Please specify valid positive integer amount for withdrawing.");
                    }
                }
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}
