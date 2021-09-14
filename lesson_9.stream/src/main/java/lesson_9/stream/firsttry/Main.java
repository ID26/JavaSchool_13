package lesson_9.stream.firsttry;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        Stream.of(2, 3, 0, 1, 3)
//                .flatMapToInt(x -> IntStream.range(0, x))
//                .forEach(System.out::print);// 010120012

//        Stream.of(2, 3, 0, 1, 3)
//                .map(x -> IntStream.range(0, x))
//                .forEach(System.out::println);//перечень стримов(потоков);

//        Stream.of(2, 3, 0, 1, 3).limit(5).forEach(x -> System.out.println(x));

//        Stream.of(2, 3, 0, 1, 3).skip(3).forEach(System.out::println);

//        Stream.of(2, 3, 0, 1, 3).sorted().forEach(System.out::println);

//        Stream.of(2, 3, 0, 1, 3).sorted().distinct().forEach(System.out::print);

//        Predicate<Integer> isPositive = x -> x > 0;
//        System.out.println(isPositive.test(3)); // true
//        System.out.println(isPositive.test(-9)); // false

//        List<String> list = Stream.of("Two", "One", "Three").sorted().collect(Collectors.toList());
//        list.forEach(s -> System.out.print(s + ", \n"));




    }
}
