package ru.sberbank.denisov26.lesson_1.temperatureconverter;

public class CelsiusToKelvin {
    private int celsius;

    public CelsiusToKelvin(int celsius) {
        this.celsius = celsius;
    }

    public double convertCelsiusToKelvin() {
        return (celsius + 273.15);
    }
}
