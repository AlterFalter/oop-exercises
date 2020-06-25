/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk12.exercise2;

import ch.hslu.wk13.exercise2.Temperature;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Student
 */
public class TemperatureHistoryDemo implements TemperatureHistoryNewMaxListener {
    private static final Logger LOG = LogManager.getLogger(TemperatureHistoryDemo.class);
    public static void main(String[] args) {
        TemperatureHistoryDemo demo = new TemperatureHistoryDemo();
        
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.addNewMaxListener(demo);
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String userInput = "";
        boolean inputIsNotExit = true;
        do {
            System.out.println("Enter new temperature in Kelvin or \"exit\" for ending the program:");
            try {
                userInput = reader.readLine();
                System.out.println("User input: " + userInput);
                inputIsNotExit = !userInput.equals("exit");
                if (inputIsNotExit) {
                    Temperature newTemperature = new Temperature(Float.parseFloat(userInput));
                    temperatureHistory.addTemperature(newTemperature);
                }
            } catch (Exception e) {
                LOG.error(e);
                System.out.println("The input has a problem. Please try again!");
            }
        } while (inputIsNotExit);
        if (temperatureHistory.hasTemperatures()) {
            System.out.println(temperatureHistory.getStatistics());
        }
        System.out.println("Program ended");
    }

    @Override
    public void notifyOnNewMaxInTemperatureHistory(TemperatureMaxChangeEvent event) {
        System.out.println("Thx for new max: " + event.getNewValue());
    }
}
