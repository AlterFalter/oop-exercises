/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11.exercise1;

import java.util.Scanner;

/**
 *
 * @author yannk
 */
public class DemoNumberInput {
    public static void main(String[] args) {
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
        System.out.println("program ended");
    }
}
