package ru.sberbank.denisov26.Lesson_6.myiterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.*;

public class MyIteratorTest {
    private MyIterator iterator;
    private String[] arr;


    @Before
    public void setUp() throws Exception {
        //создаем тестовые данные
        arr = new String[50];
        iterator = new MyIterator<>(arr);
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = String.valueOf(i);
        }
    }


    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        iterator.remove();
    }

    @Test
    public void hasNext() {
        arr = new String[0];
        boolean b = new MyIterator<>(arr).hasNext();
        Assert.assertEquals(b, false);
    }

    @Test
    public void hasNext_not_empty() {
        boolean b = iterator.hasNext();
        Assert.assertEquals(b, true);
    }

    @Test
    public void next() {
        String s;
        for (int i = 0; i < arr.length ; i++) {
            s = (String) iterator.next();
            Assert.assertEquals(s, arr[i]);
        }

    }

    @Test(expected = NoSuchElementException.class)
    public void next_empty() {
        iterator = new MyIterator<>(new String[0]);
        String s = (String) iterator.next();
    }
//    test hasNext on an empty collection (returns false)
//    test next() on an empty collection (throws exception)
//    test hasNext on a collection with one item (returns true, several times)
//    test hasNext/next on a collection with one item: hasNext returns true, next returns the item, hasNext returns false, twice
//    test remove on that collection: check size is 0 after
//    test remove again: exception
//    final test with a collection with several items, make sure the iterator goes through each item, in the correct order (if there is one)
//    remove all elements from the collection: collection is now empty

    //    @After
//    public void tearDown() throws Exception {
//    }

//    @Test
//    public void array_NOT_NULL() {
////        arr = null;
//        Assert.assertNotNull(arr);
//    }




}