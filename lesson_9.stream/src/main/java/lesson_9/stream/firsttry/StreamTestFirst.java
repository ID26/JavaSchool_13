package lesson_9.stream.firsttry;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTestFirst {
    public static void main(String[] args) throws IOException {

//        1)Используя Stream API и List<Cat> верните самое длинное имя кота в этом списке.
//        2)Используя Stream API и List<Integer> выделите только нечетные числа, отсортируйте их
//        по возрастанию и соберите в новый список.
//        3)Используя Stream API верните адрес файла с максимальным размером в заданном
//        каталоге.

//        1) Удалите из строки текста все слова длиннее 5 символов.
//        2) Удалите из строки символы которые не являются буквами английского алфавита.
//        3) Удалите из List<Cat> всех кошек вес которых меньше 3 кг, отсортируйте их по именам (в
//                лексикографическом порядке) и соберите результат в новый список Cat.
//        4) Ниже приведен фрагмент XML документа (pom.xml — используется в Maven для указания
//                зависимостей)
//                <dependency>
//<groupId>junit</groupId>
//<artifactId>junit</artifactId>
//<version>4.4</version>
//<scope>test</scope>
//</dependency>
//<dependency>
//<groupId>org.powermock</groupId>
//<artifactId>powermock-reflect</artifactId>
//<version>3.2</version>
//</dependency>
//                Поместите эти строки в массив строк, создайте поток на его основе и выделите значения в теге <groupid> и
//        соберите результат в список строк.

//        List<Mouse> mice = Arrays.asList(new Mouse("Jerry", 5, 100, "grey"),
//                new Mouse("Harry", 13, 150, "brown"),
//                new Mouse("Barry", 4, 120, "white"),
//                new Mouse("Larry", 2, 90, "red"),
//                new Mouse("Marry", 1, 70, "black"),
//                new Mouse("Ben Gun", 1, 70, "black"));
//
//        mice.stream().map(Mouse::getName).max(Comparator.comparingInt(String::length)).ifPresent(System.out::print);
//        System.out.println();
//
//        List<Integer> integers = Arrays.asList(1, 9, 8, 2, 5, 0, 3, 0, 6, 1, 44);
//        List<Integer> collect = integers.stream().filter(x -> x % 2 == 0).distinct().sorted().collect(Collectors.toList());
//        collect.forEach(s -> System.out.print(s + " "));


        Stream<Path> list = Files.list(Paths.get("C:\\laptop_SONY\\Рабочий стол\\Files"));
        list.forEach(s -> System.out.println(s));
//        list.map(Files::readAllBytes).max(Comparator.comparingInt()).ifPresent(System.out::print);


//        Создание потоков
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1,2,3,4,5});
        Stream<String> stream2 = Files.lines(new File("test.txt").toPath());


    }
}
