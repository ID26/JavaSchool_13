package lesson_9.stream.firsttry;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamPipe<T> implements Spliterator<T> {

    List<? extends T> list;

    private StreamPipe(List<? extends T> list) {
        this.list = list;
    }

    public static StreamPipe<?> of(List<?> list) {
        return new StreamPipe<>(list);
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return 0;
    }

    @Override
    public int characteristics() {
        return 0;
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {

    }

    @Override
    public long getExactSizeIfKnown() {
        return 0;
    }

    @Override
    public boolean hasCharacteristics(int characteristics) {
        return false;
    }

    @Override
    public Comparator<? super T> getComparator() {
        return null;
    }


}
