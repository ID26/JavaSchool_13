package ru.sberbank.denisov26.lesson_4.readcontent.terminal.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PasswordListener extends JFrame implements KeyListener {

    private JLabel label = new JLabel("Enter pin:", SwingConstants.CENTER);
    private JLabel[] pin = new JLabel[4];


    public PasswordListener() {
        super("Password window");
        this.setBounds(100, 100, 600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 6, 2));
        container.add(label);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
