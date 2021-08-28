package ru.sberbank.denisov26.lesson_4.readcontent.terminal.command;


import ru.sberbank.denisov26.lesson_4.readcontent.terminal.exceptions.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException;
}
