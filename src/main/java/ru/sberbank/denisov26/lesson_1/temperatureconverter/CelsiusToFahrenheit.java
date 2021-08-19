package ru.sberbank.denisov26.lesson_1.temperatureconverter;

public class CelsiusToFahrenheit implements TemperatureConverter{
    private int celsius;

    public CelsiusToFahrenheit(int celsius) {
        this.celsius = celsius;
    }

    public double convert() {
        return (celsius * 1.8 + 32);
    }
}
