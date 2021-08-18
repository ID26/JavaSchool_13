package ru.sberbank.denisov26.lesson_1.hierarchyofinheritanceofshapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        Square squareRed = new Square("Red", 5);
        System.out.println(squareRed.getPerimeter());
        System.out.println(squareRed.getSquare());
        Square squareGreen = new Square("Green", 5);
        System.out.println(squareGreen.equals(squareRed));
        Square squareGreenAnother = new Square("Green", 5);
        System.out.println(squareGreen.equals(squareGreenAnother));

        shapes.add(squareGreen);
        shapes.add(squareGreenAnother);
        shapes.add(squareRed);
        shapes.add(new Circle("Yellow", 7));
        shapes.add(new Triangle("Purple", 3, 4, 5));

        for (Shape shape : shapes) {
            System.out.println(shape + " " + shape.hashCode());
        }


    }
}
