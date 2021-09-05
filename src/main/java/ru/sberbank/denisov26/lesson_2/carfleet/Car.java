package ru.sberbank.denisov26.lesson_2.carfleet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    String model;
    String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public static void main(String[] args) {
        List<Car> carFleet = new ArrayList<>();
        carFleet.add(new Car("Lada", "Sedan"));
        carFleet.add(new Car("Lada", "Hatchback"));
        carFleet.add(new Car("Mercedes", "Sedan"));
        carFleet.add(new Car("BMW", "Crossover"));
        carFleet.add(new Car("Ford", "Hatchback"));
        carFleet.add(new Car("Peugeot", "Crossover"));
        carFleet.add(new Car("Toyota", "Sedan"));

        List<Car> sedans = new ArrayList<>();
        for (Car car : carFleet) {
            if ("Sedan".equalsIgnoreCase(car.type)) {
                sedans.add(car);
            }
        }
        sedans.stream().forEach(System.out::println);

        System.out.println("***************************************************");

        List<Car> hatchback = carFleet.stream()
                .filter(s -> "hatchback".equalsIgnoreCase(s.type)).collect(Collectors.toList());
        List<Car> crossover = carFleet.stream()
                .filter(s -> "crossover".equalsIgnoreCase(s.type)).collect(Collectors.toList());


        hatchback.stream().forEach(System.out::println);
        System.out.println("***************************************************");
        crossover.stream().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
