package ru.sberbank.denisov26.lesson_1.temperatureconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {

    public static void main(String[] args) {
        BufferedReader bufferedReader;
        while (true) {
            String temperature;
            int temperatureByCelsius;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter temperature in Celsius: ");
                temperature = bufferedReader.readLine();
                if ("exit".equalsIgnoreCase(temperature)) {
                    bufferedReader.close();
                    return;
                }

                temperatureByCelsius = Integer.parseInt(temperature);

                System.out.println("Enter temperature scale: F or K");
                String scale;
                while (true) {
                    scale = bufferedReader.readLine();
                    if ("exit".equalsIgnoreCase(scale)) {
                        bufferedReader.close();
                        return;
                    }
                    switch (scale.toUpperCase()) {
                        case "F":
                            System.out.printf("Переводим %d градусов по C в %.1f degrees F\n\r", temperatureByCelsius,
                                    new CelsiusToFahrenheit(temperatureByCelsius).convert());
                            break;

                        case "K":
                            System.out.printf("Переводим %d градусов по C в %.2f degrees K\n\r", temperatureByCelsius,
                                    new CelsiusToKelvin(temperatureByCelsius).convert());
                            break;
                        default:
                            System.out.println("Choose F or K");
                    }
                }

            }  catch (NumberFormatException exception) {
                System.out.println("Incorrect value temperature, try again with correct value");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
