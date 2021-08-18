package ru.sberbank.denisov26.lesson_1.hierarchyofinheritanceofshapes;

import java.util.Objects;

public class Rect extends Shape {
    private int sideA;
    private int sideB;

    private double perimeter;
    private double square;

    public Rect(String color, int sideA, int sideB) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.perimeter = 2 * (sideA + sideB);
        this.square = sideA * sideB;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "Rect{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", perimeter=" + perimeter +
                ", square=" + square +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect rect = (Rect) o;
        return sideA == rect.sideA &&
                sideB == rect.sideB &&
                color.equals(rect.color) &&
                Double.compare(rect.perimeter, perimeter) == 0 &&
                Double.compare(rect.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB, color, perimeter, square);
    }
}
