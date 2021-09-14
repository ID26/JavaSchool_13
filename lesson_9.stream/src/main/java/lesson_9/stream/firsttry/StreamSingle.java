package lesson_9.stream.firsttry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamSingle<T> implements Iterator<T> {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 6, 9, 15, 11, 4, 7, 8, 0, 32);
//        StreamSingle.of(list).filter(x -> x < 11);
    }
    private List<T> list;

    private StreamSingle(List<T> list) {
        this.list = list;
    }

    public void filter() {

//        List<? super T> filteredList = new ArrayList<>();
//        for (T temp : list) {
//            if (predicate.test(t)) {
//                list.add(temp);
//            }
//        }

    }

    //    Streams.of() - статический метод, который принимает коллекцию и создает новый объект Streams
//filter() - оставляет в коллекции только те элементы, которые удовлетворяют условию в лямбде.
//transform() - преобразует элемент в другой.
//toMap - принимает 2 лямбды для создания мапы, в одной указывается, что использовать в качестве ключа, в другой, что в качестве значения.
//После выполнения всех операций коллекция someCollection не должна поменяться.
//Класс надо параметризовать используя правило PECS



    public static StreamSingle of (List<?> list) {
        return new StreamSingle(list);
    }

    @Override
    public void forEachRemaining(Consumer action) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
