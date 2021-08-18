package ru.sberbank.denisov26.lesson_1.hierarchyofinheritanceofshapes;

import java.util.Objects;

public class Circle extends Shape {
    private int radius;
    private double lengthOfCircle;
    private double squareCircle;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
        this.lengthOfCircle = 2 * 3.14 * radius;
        this.squareCircle = 3.14 * Math.pow(radius, 2);
    }

    public int getRadius() {
        return radius;
    }

    public double getLengthOfCircle() {
        return lengthOfCircle;
    }

    public double getSquareCircle() {
        return squareCircle;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", lengthOfCircle=" + lengthOfCircle +
                ", squareCircle=" + squareCircle +
                ", color='" + color + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                color.equals(circle.color) &&
                Double.compare(circle.lengthOfCircle, lengthOfCircle) == 0 &&
                Double.compare(circle.squareCircle, squareCircle) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color, lengthOfCircle, squareCircle);
    }
}
