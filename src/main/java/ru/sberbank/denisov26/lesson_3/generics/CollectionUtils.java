package ru.sberbank.denisov26.lesson_3.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static void main(String[] args) {
        List<Integer> integers = newArrayList();
        addAll(Arrays.asList(4, 1, 5, 9, 11, 2, 7, 5, 8, 123, 37), integers);
        System.out.println("Get index element: " + indexOf(integers, 123));
        System.out.println("List limited some value: " + limit(integers, 10).size());
        add(integers, 65);
        System.out.print("List integer to string: ");
        integers.stream().forEach(s-> System.out.print(s + " "));
        System.out.println();
        List<Integer> secondList = newArrayList();
        addAll(Arrays.asList(3, 7, 9, 11, 5, 1), secondList);
        List<Integer> thirdList = new ArrayList<>(secondList);
        System.out.println("list second contains all elements from third" + containsAll(secondList, thirdList));
        System.out.print("List third to string: ");
        thirdList.stream().forEach(s-> System.out.print(s + " "));
        System.out.println();
        removeAll(secondList, integers);
        System.out.println("list second contains all elements from third: " + containsAll(secondList, thirdList));
        System.out.println("list second contains any elements from third: " + containsAny(secondList, thirdList));

        System.out.print("List integer above 14 and below 81 to string without comparator: ");
        range(integers, 15, 80)
                .stream().forEach(s -> System.out.print(s + " "));
        System.out.println();

        System.out.print("List integer above 4 and below 81 to string: ");
        range(integers, 5, 80, (o1, o2) -> o1 - o2)
                .stream().forEach(s -> System.out.print(s + " "));


    }

    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T t) {
        return source.indexOf(t);
    }
// hz
    public static <T> List<T> limit(List<? extends T> source, int size) {
//        return source.
        return (List<T>) source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c2) {
            return c1.contains(t);
        }
        return false;
    }

    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<T> result = newArrayList();
        for (T t : list) {
            if (t.compareTo(min) >= 0 && t.compareTo(max) <= 0) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T> List<? super T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> result = newArrayList();
        for (T t : list) {
            if (comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0) {
                result.add(t);
            }
        }
        return result;
    }

}
