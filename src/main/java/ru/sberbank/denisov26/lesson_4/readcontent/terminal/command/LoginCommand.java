package ru.sberbank.denisov26.lesson_4.readcontent.terminal.command;


import ru.sberbank.denisov26.lesson_4.readcontent.terminal.CashMachine;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.ConsoleHelper;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.AccountIsLockedException;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(/*CashMachine.RESOURCE_PATH + */"verifiedCards"/*, Locale.ENGLISH*/);
    private ResourceBundle res = ResourceBundle.getBundle(/*CashMachine.RESOURCE_PATH + */"login"/*, Locale.ENGLISH*/);


    public ResourceBundle getValidCreditCards() {
        return validCreditCards;
    }

    public ResourceBundle getRes() {
        return res;
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        int tryCounter = 0;

        while (true) {
            if (tryCounter >= 3) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new AccountIsLockedException();
                } finally {
                    tryCounter = 0;
                }
            }
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String creditCardNumber = ConsoleHelper.readString();

            String pinStr = null;
            int countVerificationPin = 0;
            while (countVerificationPin < 3) {
                pinStr = ConsoleHelper.readPin();
                if (validCreditCards.getString(creditCardNumber).equals(pinStr)) {
                    System.out.println("successfully");
                } else {
                    countVerificationPin++;
                }
            }
            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
                    pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            } else {
                try {
                    if (validCreditCards.containsKey(creditCardNumber) && pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                        break;
                    } else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
        }
    }
}
