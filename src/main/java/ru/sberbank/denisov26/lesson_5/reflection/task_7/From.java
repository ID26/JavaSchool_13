package ru.sberbank.denisov26.lesson_5.reflection.task_7;

import java.util.Objects;

public class From {
    private String s;
    private int i;

    @Override
    public String toString() {
        return "From{" +
                "s='" + s + '\'' +
                ", i=" + i +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof From)) return false;
        From from = (From) o;
        return i == from.i &&
                Objects.equals(s, from.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, i);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public From(String s, int i) {
        this.s = s;
        this.i = i;
    }
}
