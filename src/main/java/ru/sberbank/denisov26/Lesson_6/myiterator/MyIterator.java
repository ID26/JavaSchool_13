package ru.sberbank.denisov26.Lesson_6.myiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyIterator<T> implements Iterator<T> {
    private T[] myArray;
    private int myArraySize;
    private int currentIndex = 0;

    public MyIterator(T[] myArray) {
        if (myArray == null) {
            return;
        }
        this.myArray = myArray;
        this.myArraySize = myArray.length;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < myArraySize && myArray[currentIndex] != null;
    }

    @Override
    public T next() throws NoSuchElementException {
        try {
            return myArray[currentIndex++];
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
