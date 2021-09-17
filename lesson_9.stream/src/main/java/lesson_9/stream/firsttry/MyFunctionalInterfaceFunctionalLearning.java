package lesson_9.stream.firsttry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MyFunctionalInterfaceFunctionalLearning {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Funk", "Frank", "Duck", "Fat", "Angry", "Eagle"));

    }


}

class MyFunctional implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        return s.length() % 2;
    }
}
