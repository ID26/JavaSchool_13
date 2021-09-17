package lesson_9.stream.firsttry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyFunctionalInterfacesPredicateLearning {
    public static void main(String[] args) {
        System.out.println(8/2*(2 + 2));
//        List<String> list = new ArrayList<>(List.of("Funk", "Frank", "Duck", "Fat", "Angry", "Eagle"));
        List<String> list = new ArrayList<>(Arrays.asList("Funk", "Frank", "Duck", "Fat", "Angry", "Eagle"));
//        List<String> list = getStrings();
//        list.removeIf(x -> x.startsWith("F"));
//        list.forEach(System.out::println);
        Predicate<String> pr1 = x -> x.startsWith("F");
        Predicate<String> pr2 = x -> x.length() > 3;
        Predicate<String> pr3 = x -> x.startsWith("E");
        Predicate<String> pr4 = x -> x.startsWith("D");
        Predicate<String> pr5 = x -> x.startsWith("A");
        list.stream().filter(Predicate.isEqual(pr1)).collect(Collectors.toList()).forEach((s)-> System.out.println(s));
//        list.stream().filter(pr1.negate()).collect(Collectors.toList()).forEach(System.out::println);
//        list.stream().filter(pr1.or(pr2)).collect(Collectors.toList()).forEach(System.out::println);
//        List<String> collect = list.stream().filter(x -> !x.startsWith("f".toUpperCase())).
//                filter(x -> !(x.length() > 4)).collect(Collectors.toList());
//        collect.forEach(System.out::println);
//        List<String> collect = list.stream().filter(MyFunctionalInterfacesLearning::startWithF).
//                filter(MyFunctionalInterfacesLearning::lengthLongerThanFour).collect(Collectors.toList());
//        collect.forEach(System.out::println);
    }

    private static List<String> getStrings() {
        List<String> strings = new ArrayList<>();
        strings.add("Frank");
        strings.add("Greg");
        strings.add("Round");
        strings.add("Triangle");
        strings.add("Auxiliary");
        strings.add("Sextant");
        strings.add("Star board side");
        return strings;
    }

    private static boolean startWithF(String s) {
        return s.startsWith("F");
    }

    private static boolean lengthLongerThanFour(String s) {
        return s.length() > 4;
    }
}
