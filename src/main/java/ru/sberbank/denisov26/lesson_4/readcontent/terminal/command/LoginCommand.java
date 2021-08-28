package ru.sberbank.denisov26.lesson_4.readcontent.terminal.command;


import ru.sberbank.denisov26.lesson_4.readcontent.terminal.CashMachine;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.ConsoleHelper;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.AccountIsLockedException;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(/*CashMachine.RESOURCE_PATH + */"verifiedCards"/*, Locale.ENGLISH*/);
    private ResourceBundle res = ResourceBundle.getBundle(/*CashMachine.RESOURCE_PATH + */"login"/*, Locale.ENGLISH*/);


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
                        ConsoleHelper.writeMessage(res.getString("specify.data.pin"));
                        String pinStr;
                        while (true) {
                            for (int i = 0; i < 3; i++) {
                                pinStr = ConsoleHelper.readPin();
                                if (pinStr.equals(validCreditCards.getString(creditCardNumber))) {
                                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
                                    return;
                                } else {
                                    ConsoleHelper.writeMessage(res.getString("try.again.with.details.pin"));
                                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                                }
                            }
                            ConsoleHelper.writeMessage(res.getString("account.is.locked"));
                            Calendar calendar = Calendar.getInstance();
                            long start = calendar.getTimeInMillis();
//                            Thread blocked = new Thread(() -> {
//                                int count = 0;
//                              while (count < 10) {
//                                  try {
//                                      if (ConsoleHelper.readPin() != null) {
//                                          throw new AccountIsLockedException(calendar.getTimeInMillis() - start);
//                                      }
//                                      try {
//                                          Thread.sleep(1000);
//                                      } catch (InterruptedException e) {
//                                          e.printStackTrace();
//                                      }
//                                      count++;
//                                  } catch (InterruptOperationException e) {
//
//                                  }
//                              }
//                            });
//                            blocked.start();
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                throw new AccountIsLockedException(calendar.getTimeInMillis() - start);
                            }
                        }

                    } else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
//            int countVerificationPin = 0;
//            while (countVerificationPin < 3) {
//                pinStr = ConsoleHelper.readPin();
//                if (validCreditCards.getString(creditCardNumber).equals(pinStr)) {
//                    System.out.println("successfully");
//                } else {
//                    countVerificationPin++;
//
//                }
//            }
//            if (creditCardNumber == null || (creditCardNumber = creditCardNumber.trim()).length() != 12 ||
//                    pinStr == null || (pinStr = pinStr.trim()).length() != 4) {
//                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//            } else {
//                try {
//                    if (validCreditCards.containsKey(creditCardNumber) && pinStr.equals(validCreditCards.getString(creditCardNumber))) {
//                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), creditCardNumber));
//                        break;
//                    } else {
//                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), creditCardNumber));
//                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
//                    }
//                } catch (NumberFormatException e) {
//                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
//                }
//            }
        }
    }
}
