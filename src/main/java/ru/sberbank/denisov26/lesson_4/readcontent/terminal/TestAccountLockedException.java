package ru.sberbank.denisov26.lesson_4.readcontent.terminal;

import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.AccountIsLockedException;
import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;


import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class TestAccountLockedException {
    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static int countVerificationPin = 0;

    public static void main(String[] args) {
        File file = new File(CashMachine.class.getClass().getClassLoader()
                .getResource("verifiedCards.properties").getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            while (countVerificationPin < 3) {
                String pin = readPin();
                System.out.println(pin);
                if ("2345".equals(pin)) {
                    System.out.println("successfully");
                } else {
                    countVerificationPin++;
                }
            }
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();

                long startTime = calendar.get(Calendar.SECOND);
            System.out.println("Пошел блок с неправильными" + date);
                Thread.sleep(10000);
            System.out.println("Закончился блок с неправильными" + date);

        } catch (InterruptOperationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            try {
                throw new AccountIsLockedException();
            } catch (AccountIsLockedException accountIsLockedException) {
                accountIsLockedException.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public static String readPin() throws InterruptOperationException {
        StringBuilder stringBuilder = new StringBuilder();
        int charactersCounter = 0;

        try {
            while (charactersCounter < 4) {
                String character = bis.readLine();

                if ("exit".equals(character.toLowerCase())) {
                    throw new InterruptOperationException();
                }

                if (character.matches("\\d")) {
                    stringBuilder.append(character);
                    charactersCounter++;
                } else {
                    System.out.println("Character isn't digit, enter next digit");
                }
            }

            return stringBuilder.toString();
        } catch (IOException ignored) {

        }
        return null;
    }
}
