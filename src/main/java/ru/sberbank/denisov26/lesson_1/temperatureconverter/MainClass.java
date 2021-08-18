package ru.sberbank.denisov26.lesson_1.temperatureconverter;

public class MainClass {

    public static void main(String[] args) {
        int temperatureByCelsius = 40;

        System.out.printf("Переводим %d градусов по C в %.1f degrees F\n\r", temperatureByCelsius,
                new CelsiusToFahrenheit(temperatureByCelsius).convertCelsiusToFahrenheit());

        System.out.printf("Переводим %d градусов по C в %.2f degrees K\n\r", temperatureByCelsius,
                new CelsiusToKelvin(temperatureByCelsius).convertCelsiusToKelvin());
    }
}
