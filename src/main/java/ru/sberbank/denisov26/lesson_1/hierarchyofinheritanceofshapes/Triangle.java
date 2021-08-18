package ru.sberbank.denisov26.lesson_1.hierarchyofinheritanceofshapes;

import java.util.Objects;

public class Triangle extends Shape {
    private int sideLength1;
    private int sideLength2;
    private int sideLength3;

    private double perimeterTriangle;

    public Triangle(String color, int sideLength1, int sideLength2, int sideLength3) {
        super(color);
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.sideLength3 = sideLength3;

        this.perimeterTriangle = sideLength1 + sideLength2 + sideLength3;
    }

    public int getSideLength1() {
        return sideLength1;
    }

    public int getSideLength2() {
        return sideLength2;
    }

    public int getSideLength3() {
        return sideLength3;
    }


    public double getPerimeterTriangle() {
        return perimeterTriangle;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideLength1=" + sideLength1 +
                ", sideLength2=" + sideLength2 +
                ", sideLength3=" + sideLength3 +
                ", perimeterTriangle=" + perimeterTriangle +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return sideLength1 == triangle.sideLength1 &&
                sideLength2 == triangle.sideLength2 &&
                sideLength3 == triangle.sideLength3 &&
                color.equals(triangle.color) &&
                Double.compare(triangle.perimeterTriangle, perimeterTriangle) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength1, sideLength2, color, sideLength3, perimeterTriangle);
    }
}
