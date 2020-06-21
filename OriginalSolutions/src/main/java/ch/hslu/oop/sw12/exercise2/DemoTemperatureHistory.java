/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise2;

import ch.hslu.oop.sw10.exercise1.Temperature;
import java.util.Scanner;

/**
 *
 * @author yannk
 */
public class DemoTemperatureHistory {
    private static TemperatureHistory temperatureHistory = new TemperatureHistory();
    
    public static void main(String[] args) {
        Temperature temperature;
        temperatureHistory.addMinimumChangeListener(e -> handleNewMinTemperature(e));
        temperatureHistory.addMaximumChangeListener(e -> handleNewMaxTemperature(e));
        
        do {
            temperature = getTemperatureFromUser();
            if (temperature != null) {
                temperatureHistory.add(temperature);
            }
        } while (temperature != null);
        // print statistics
        System.out.print(temperatureHistory.toString());
    }
    
    public static Temperature getTemperatureFromUser() {
        Temperature temperature;
        Scanner scanner = new Scanner(System.in);
        boolean inputIsNotExit;
        do {
            System.out.println("Please enter temperature in °C (write 'exit' to end): ");
            String input = scanner.next();
            inputIsNotExit = !input.equals("exit");
            if (inputIsNotExit) {
                try {
                    temperature = new Temperature(Temperature.celsiusToKelvin(Float.valueOf(input)));
                    System.out.println("Temperature: " + temperature + "°C");
                    return temperature;
                }
                 catch (NumberFormatException ex) {
                    System.out.println("Input has to be a number or 'exit'. Example: 24.5");
                }
                catch (IllegalArgumentException ex) {
                    // Temperature class threw an error
                    System.out.println("Input has to be in range of possibility.");
                }
            }
        } while (inputIsNotExit);
        scanner.close();
        System.out.println("exit without temperature");
        return null;
    }
    
    public static void handleNewMinTemperature(MinTemperatureChangeEvent event) {
        System.out.println("Min temperature changed");
        System.out.println(temperatureHistory.toString());
    }
    
    public static void handleNewMaxTemperature(MaxTemperatureChangeEvent event) {
        System.out.println("Max temperature changed");
        System.out.println(temperatureHistory.toString());
    }
}
