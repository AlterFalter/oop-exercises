/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11.exercise2;

/**
 * Calculations can be slightly off.
 * Minimum of each unit is defined here and is the absolute truth for this class.
 * This means that numbers don't get rounded up when checking for the minimal value.
 * @author yannk
 */
public abstract class TemperatureCalculator {
    public static final float KELVIN_MINIMUM = 0;
    // alternative for single usage: kelvinToCelsius(0)
    public static final float CELSIUS_MINIMUM = -273.15f;
    // alternative for single usage: kelvinToFahrenheit(0)
    public static final float FAHRENHEIT_MINIMUM = -459.67f;
    
    // possible refactoring to private method and given argument in the message
    // --> could also raise error there 
    private static final String KELVIN_VALUE_ERROR_MESSAGE = "Kelvin value should be at least " + KELVIN_MINIMUM + " | Value was: ";
    private static final String CELSIUS_VALUE_ERROR_MESSAGE = "Celsius value should be at least " + CELSIUS_MINIMUM + " | Value was: ";
    private static final String FAHRENHEIT_VALUE_ERROR_MESSAGE = "Fahrenheit value should be at least " + FAHRENHEIT_MINIMUM + " | Value was: ";
    
    public final static float celsiusToKelvin(float temperatureInCelsius) {
        checkCelsiusValue(temperatureInCelsius);
        return temperatureInCelsius - CELSIUS_MINIMUM;
    }
    
    public final static float kelvinToCelsius(float temperatureInKelvin) {
        checkKelvinValue(temperatureInKelvin);
        return temperatureInKelvin + CELSIUS_MINIMUM;
    }
    
    public final static float celsiusToFahrenheit(float temperatureInCelsius) {
        checkCelsiusValue(temperatureInCelsius);
        return temperatureInCelsius * 1.8f + 32f;
    }
    
    public final static float fahrenheitToCelsius(float temperatureInFahrenheit) {
        checkFahrenheitValue(temperatureInFahrenheit);
        return (temperatureInFahrenheit - 32f) / 1.8f;
    }
    
    public final static float kelvinToFahrenheit(float temperatureInKelvin) {
        checkKelvinValue(temperatureInKelvin);
        return temperatureInKelvin * 1.8f + FAHRENHEIT_MINIMUM;
    }
    
    public final static float fahrenheitToKelvin(float temperatureInFahrenheit) {
        checkFahrenheitValue(temperatureInFahrenheit);
        return (temperatureInFahrenheit - FAHRENHEIT_MINIMUM) / 1.8f;
    }
    
    public final static boolean isKelvinValueValid(float temperatureInKelvin) {
        return temperatureInKelvin >= KELVIN_MINIMUM;
    }
    
    public final static boolean isCelsiusValueValid(float temperatureInCelsius) {
        return temperatureInCelsius >= CELSIUS_MINIMUM;
    }
    
    public final static boolean isFahrenheitValueValid(float temperatureInFahrenheit) {
        return temperatureInFahrenheit >= FAHRENHEIT_MINIMUM;
    }
    
    public final static void checkKelvinValue(float temperatureInKelvin) {
        if (!isKelvinValueValid(temperatureInKelvin)) {
            throw new IllegalArgumentException(KELVIN_VALUE_ERROR_MESSAGE + temperatureInKelvin);
        }
    }
    
    public final static void checkCelsiusValue(float temperatureInCelsius) {
        if (!isCelsiusValueValid(temperatureInCelsius)) {
            throw new IllegalArgumentException(CELSIUS_VALUE_ERROR_MESSAGE + temperatureInCelsius);
        }
    }
    
    public final static void checkFahrenheitValue(float temperatureInFahrenheit) {
        if (!isFahrenheitValueValid(temperatureInFahrenheit)) {
            throw new IllegalArgumentException(FAHRENHEIT_VALUE_ERROR_MESSAGE + temperatureInFahrenheit);
        }
    }
}
