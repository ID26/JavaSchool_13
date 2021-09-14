package lesson_9.stream.firsttry;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams<T> {
    public Collection<? extends T> collection;
    private Streams(Collection<? extends T> collection) {
        this.collection = new ArrayList<>(collection);
    }

    public static <T> Streams<T> of(Collection<? extends T> collection) {
        return new Streams<>(collection);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> list = new ArrayList<T>();
        for(T element : collection)
            if(predicate.test(element))
                list.add(element);
        return Streams.of(list);
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> function) {
        List<R> list = new ArrayList<R>();
        for(T element : collection)
            list.add(function.apply(element));
        return Streams.of(list);
    }

    public <K,V> Map<K,V> toMap(Function<? super T, ? extends K> funcKey, Function<? super T, ? extends V> funcValue) {
        Map<K,V> map = new HashMap<>();
        for(T element : collection)
            map.put(funcKey.apply(element), funcValue.apply(element));
        return map;
    }

//    Streams.of() - статический метод, который принимает коллекцию и создает новый объект Streams
//    filter() - оставляет в коллекции только те элементы, которые удовлетворяют условию в лямбде.
//    transform() - преобразует элемент в другой.
//    toMap - принимает 2 лямбды для создания мапы, в одной указывается, что использовать в качестве ключа, в другой, что в качестве значения.
//    После выполнения всех операций коллекция someCollection не должна поменяться.
//    Класс надо параметризовать используя правило PECS

}
