package ru.sberbank.denisov26.lesson_4.readcontent.terminal;

import ru.sberbank.denisov26.lesson_4.readcontent.terminal.view.PasswordListener;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sandbox {
    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static int countVerificationPin = 0;

    public static void main(String[] args) {
        PasswordListener passwordListener = new PasswordListener();
//        PasswordGUI passwordGUI = new PasswordGUI();
//        passwordGUI.setVisible(true);
//        EnterKeyListener keyListener = new EnterKeyListener();

//        long timeToAccountBlocked = System.currentTimeMillis() + 10000;
//        long sec;
//        EnterKeyListener keyListener;
//        while ((sec = (timeToAccountBlocked - System.currentTimeMillis()) / 1000) > 0) {
//            keyListener = new EnterKeyListener(sec);
//        }

//        Calendar calendar = Calendar.getInstance();
//        long start = calendar.getTimeInMillis();
//        System.out.println(start);
//        while ((start + 10000) > calendar.getTimeInMillis()) {
////            bis.readLine()
//        }

//        File file = new File(CashMachine.class.getClass().getClassLoader()
//                .getResource("verifiedCards.properties").getFile());
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//        try {
//            while (countVerificationPin < 3) {
//                String pin = readPin();
//                System.out.println(pin);
//                if ("2345".equals(pin)) {
//                    System.out.println("successfully");
//                } else {
//                    countVerificationPin++;
//                }
//            }
//            Calendar calendar = Calendar.getInstance();
//            Date date = calendar.getTime();
//
//                long startTime = calendar.get(Calendar.SECOND);
//            System.out.println("Пошел блок с неправильными" + date);
//                Thread.sleep(10000);
//            System.out.println("Закончился блок с неправильными" + date);
//
//        } catch (InterruptOperationException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            try {
//                throw new AccountIsLockedException();
//            } catch (AccountIsLockedException accountIsLockedException) {
//                accountIsLockedException.printStackTrace();
//            }
//            e.printStackTrace();
//        }
//
//    }
//
//    public static String readPin() throws InterruptOperationException {
//        StringBuilder stringBuilder = new StringBuilder();
//        int charactersCounter = 0;
//
//        try {
//            while (charactersCounter < 4) {
//                String character = bis.readLine();
//
//                if ("exit".equals(character.toLowerCase())) {
//                    throw new InterruptOperationException();
//                }
//
//                if (character.matches("\\d")) {
//                    stringBuilder.append(character);
//                    charactersCounter++;
//                } else {
//                    System.out.println("Character isn't digit, enter next digit");
//                }
//            }
//
//            return stringBuilder.toString();
//        } catch (IOException ignored) {
//
//        }
//        return null;
    }
}
