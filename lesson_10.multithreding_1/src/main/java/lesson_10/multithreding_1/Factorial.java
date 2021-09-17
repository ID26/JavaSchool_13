package lesson_10.multithreding_1;


import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class Factorial/*implements Runnable*/ {

    private int factor;

    public Factorial(int num) {
        this.factor = calcFactorial(num);
    }

    private int calcFactorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * calcFactorial(num - 1);
    }

    public int getFactorial() {
        return factor;
    }

    @Override
    public String toString() {
        return "Factorial{" +
                "factor=" + factor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factorial)) return false;
        Factorial factorial = (Factorial) o;
        return factor == factorial.factor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(factor);
    }
}
