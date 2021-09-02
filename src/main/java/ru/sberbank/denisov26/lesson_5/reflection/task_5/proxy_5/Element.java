package ru.sberbank.denisov26.lesson_5.reflection.task_5.proxy_5;

import java.util.List;
import java.util.Objects;

public class Element {
    private List<Object> key;
    private Object value;

    public List<Object> getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public Element(List<Object> key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element)) return false;
        Element element = (Element) o;
        return Objects.equals(key, element.key) &&
                Objects.equals(value, element.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "Element{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}


//public class Element<K, V> {
//    private K key;
//    private V value;
//
//    public Element(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public K getKey() {
//        return key;
//    }
//
//    public V getValue() {
//        return value;
//    }
//
//
//}
