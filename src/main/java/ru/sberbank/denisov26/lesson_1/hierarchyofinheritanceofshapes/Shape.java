package ru.sberbank.denisov26.lesson_1.hierarchyofinheritanceofshapes;

public abstract class Shape {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shapes{" +
                "color='" + color + '\'' +
                '}';
    }
}
