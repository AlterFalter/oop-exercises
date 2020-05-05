/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11.exercise3;

import java.util.Optional;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class DemoNumberInputWithLogger {
    private static final Logger LOG = LogManager.getLogger(DemoNumberInputWithLogger.class);
    
    public static void main(String[] args) {
        logDifferentLevels();
        
        Optional<Float> numberInput = getNumberFromUser();
        if (numberInput.isPresent()) {
            Float number = numberInput.get();
            LOG.info("input from user: " + number);
        }
        else {
            LOG.info("no user input");
        }
        
        System.out.println("#########################################");
        
        LOG.info("Started temperature input sequence.");
        float temperature;
        Scanner scanner = new Scanner(System.in);
        boolean inputIsNotExit;
        boolean noValidNumberWasEntered = true;
        do {
            LOG.debug("Get input from user.");
            System.out.println("Please enter temperature in °C (write 'exit' to end): ");
            String input = scanner.next();
            LOG.info("got input from user: " + input);
            inputIsNotExit = !input.equals("exit");
            if (inputIsNotExit) {
                LOG.debug("input is not 'exit'. Will try to convert to number.");
                try {
                    temperature = Float.valueOf(input);
                    noValidNumberWasEntered = false;
                    System.out.println("Temperature: " + temperature + "°C");
                    LOG.info("Input was converted successfully to a number.");
                }
                catch (NumberFormatException ex) {
                    System.out.println("Input has to be a number or 'exit'. Example: 24.5");
                    LOG.error("Input couldn't be converted to a number and wasn't 'exit' either. Input: " + input, ex);
                }
            }
            else {
                LOG.warn("Input was 'exit'. Leave loop without a number.");
            }
        } while (inputIsNotExit && noValidNumberWasEntered);
        LOG.debug("Loop ended.");
        System.out.println("program ended");
        LOG.info("Program ended.");
    }
    
    private static void logDifferentLevels() {
        // even more information than debug
        LOG.trace("This is a trace message");
        
        // know nearly everything that happened inside application
        LOG.debug("This is a debug message");
        
        // show progression from application
        LOG.info("This is an info message");
        
        // something could lead to an error in the future
        LOG.warn("This is a warn message");
        
        // error occured
        LOG.error("This is an error message");
        
        // severe error occured, program can't progress any further
        LOG.fatal("This is a fatal message");
    }
    
    /**
     * Doesn't work in Java because also wrapper types, such as Float, are not mutable!
     * --> nullable Float
     * --> Optional<Float> --> java.util.Optional
     * Alternative: use events!
     * OR: write a class with a single float attribute and getter/setter functions
     * 
     * 
     * @param inputNumber
     * @return 
     */
    public static Optional<Float> getNumberFromUser() {
        LOG.info("Started temperature input sequence.");
        Scanner scanner = new Scanner(System.in);
        boolean inputIsNotExit;
        do {
            LOG.debug("Get input from user.");
            System.out.println("Please enter temperature in °C (write 'exit' to end): ");
            String input = scanner.next();
            LOG.info("got input from user: " + input);
            inputIsNotExit = !input.equals("exit");
            if (inputIsNotExit) {
                LOG.debug("input is not 'exit'. Will try to convert to number.");
                try {
                    Optional<Float> inputNumber = Optional.ofNullable(Float.valueOf(input));
                    System.out.println("Temperature: " + inputNumber + "°C");
                    LOG.info("Input was converted successfully to a number.");
                    return inputNumber;
                }
                catch (NumberFormatException ex) {
                    System.out.println("Input has to be a number or 'exit'. Example: 24.5");
                    LOG.error("Input couldn't be converted to a number and wasn't 'exit' either. Input: " + input, ex);
                }
            }
            else {
                LOG.warn("Input was 'exit'. Leave loop without a number.");
            }
        } while (inputIsNotExit);
        LOG.debug("Loop ended.");
        return Optional.ofNullable(null);
    }
}
