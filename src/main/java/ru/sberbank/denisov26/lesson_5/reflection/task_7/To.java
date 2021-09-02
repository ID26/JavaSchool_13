package ru.sberbank.denisov26.lesson_5.reflection.task_7;

import java.util.Objects;

public class To {
    private int i;
    private String s;
    private Character ch;

    public To(int i, String s, Character ch) {
        this.i = i;
        this.s = s;
        this.ch = ch;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof To)) return false;
        To to = (To) o;
        return i == to.i &&
                Objects.equals(s, to.s) &&
                Objects.equals(ch, to.ch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, s, ch);
    }

    @Override
    public String toString() {
        return "To{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", ch=" + ch +
                '}';
    }

    public To() {
    }
}
