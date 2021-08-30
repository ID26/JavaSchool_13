package ru.sberbank.denisov26.lesson_4.readcontent.terminal.command;


import ru.sberbank.denisov26.lesson_4.readcontent.terminal.ConsoleHelper;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.AccountIsLockedException;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle("verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle("login");


    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data.card.number"));
        while (true) {
            String creditCardNumber = ConsoleHelper.readString();

            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details.card.number"));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            } else {
                try {
                    if (validCreditCards.containsKey(creditCardNumber)) {
                        String pinStr;
                        int count = 0;
                        while (true) {
                            ConsoleHelper.writeMessage(res.getString("specify.data.pin"));
                            while (count < 3) {
                                pinStr = ConsoleHelper.readPin();
                                if (pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                                    return;
                                } else {
                                    ConsoleHelper.writeMessage(res.getString("try.again.with.details.pin"));
                                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                                }
                                count++;
                                if (count == 3) {
                                    ConsoleHelper.writeMessage(res.getString("account.is.locked"));
                                    try {
                                        throw new AccountIsLockedException(
                                                String.format("Account wos blocked, waite %d sec", 10));
                                    } catch (AccountIsLockedException exception) {
                                        System.err.println(exception);
                                    }
                                    try {
                                        Thread.sleep(10000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }



                            ConsoleHelper.writeMessage("Account unlock");
                            count = 0;
                        }

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
