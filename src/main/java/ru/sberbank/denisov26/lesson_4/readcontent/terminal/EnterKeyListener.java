package ru.sberbank.denisov26.lesson_4.readcontent.terminal;

import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.AccountIsLockedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Formatter;

class PasswordGUI extends JFrame {
//    private JButton buttonOk = new JButton("OK");
    private JLabel label = new JLabel("Enter pin:", SwingConstants.CENTER);
    private JFormattedTextField textField = new JFormattedTextField();



    public PasswordGUI() throws HeadlessException {
        super("Enter pin code.");



//        buttonOk.addActionListener((ActionListener) new EnterKeyListener());
//        container.add(buttonOk);
    }
}


public class EnterKeyListener implements KeyListener {



    public EnterKeyListener() {
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        System.out.println(key);
            try {
                throw new AccountIsLockedException(String.format("Account is blocked, time to unlock: %d", 5));
            } catch (AccountIsLockedException exception) {
                System.err.println(exception);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
