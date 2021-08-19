package ru.sberbank.denisov26.lesson_1.temperatureconverter;

public class CelsiusToKelvin implements TemperatureConverter {
    private int celsius;

    public CelsiusToKelvin(int celsius) {
        this.celsius = celsius;
    }

    public double convert() {
        return (celsius + 273.15);
    }
}
