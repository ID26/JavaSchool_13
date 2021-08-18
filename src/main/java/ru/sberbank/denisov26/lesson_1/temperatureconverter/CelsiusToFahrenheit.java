package ru.sberbank.denisov26.lesson_1.temperatureconverter;

public class CelsiusToFahrenheit {
    private int celsius;

    public CelsiusToFahrenheit(int celsius) {
        this.celsius = celsius;
    }

    public double convertCelsiusToFahrenheit() {
        return (celsius * 1.8 + 32);
    }
}
