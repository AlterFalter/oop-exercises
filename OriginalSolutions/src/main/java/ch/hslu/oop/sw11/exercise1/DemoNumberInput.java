/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11.exercise1;

import java.util.Scanner;
import ch.hslu.oop.sw11.exercise2.Temperature;

/**
 *
 * @author yannk
 */
public class DemoNumberInput {
    public static void main(String[] args) {
        unlimitedNumbers();
        //getInputAndBreakAfterFirstNumber();
        //unlimitedTemperature();
    }
    
    public static void getInputAndBreakAfterFirstNumber() {
        float temperature;
        Scanner scanner = new Scanner(System.in);
        boolean inputIsNotExit;
        boolean noValidNumberWasEntered = true;
        do {
            System.out.println("Please enter temperature in °C (write 'exit' to end): ");
            String input = scanner.next();
            inputIsNotExit = !input.equals("exit");
            if (inputIsNotExit) {
                try {
                    temperature = Float.valueOf(input);
                    noValidNumberWasEntered = false;
                    System.out.println("Temperature: " + temperature + "°C");
                }
                catch (NumberFormatException ex) {
                    System.out.println("Input has to be a number or 'exit'. Example: 24.5");
                }
            }
        } while (inputIsNotExit && noValidNumberWasEntered);
        scanner.close();
        System.out.println("program ended");
    }
    
    /**
     * Unlimited POWER!
     */
    public static void unlimitedNumbers() {
        float temperature;
        Scanner scanner = new Scanner(System.in);
        boolean inputIsNotExit;
        do {
            System.out.println("Please enter temperature in °C (write 'exit' to end): ");
            String input = scanner.next();
            inputIsNotExit = !input.equals("exit");
            if (inputIsNotExit) {
                try {
                    temperature = Float.valueOf(input);
                    System.out.println("Temperature: " + temperature + "°C");
                }
                catch (NumberFormatException ex) {
                    System.out.println("Input has to be a number or 'exit'. Example: 24.5");
                }
            }
        } while (inputIsNotExit);
        scanner.close();
        System.out.println("program ended");
    }
    
    /**
     * Even more unlimited POWER!
     */
    public static void unlimitedTemperature() {
        Temperature temperature;
        Scanner scanner = new Scanner(System.in);
        boolean inputIsNotExit;
        do {
            System.out.println("Please enter temperature in °C (write 'exit' to end): ");
            String input = scanner.next();
            inputIsNotExit = !input.equals("exit");
            if (inputIsNotExit) {
                try {
                    temperature = Temperature.createFromCelsius(Float.valueOf(input));
                    System.out.println("Temperature: " + temperature + "°C");
                }
                catch (NumberFormatException ex) {
                    System.out.println("Input has to be a number or 'exit'. Example: 24.5");
                }
                catch (IllegalArgumentException ex) {
                    // Temperature class threw an error
                    System.out.println("Input has to be in range of possible.");
                }
            }
        } while (inputIsNotExit);
        scanner.close();
        System.out.println("program ended");
    }
}
