/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw11.exercise2;

import ch.hslu.oop.sw11.exercise2.TemperatureCalculator;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author yannk
 */
public class TemperatureCalculatorTest {
    private static final float ACCEPTABLE_DELTA = 0.01f;
    
    @Test
    public void testCelsiusToKelvinWithMinimum() {
        assertEquals(TemperatureCalculator.KELVIN_MINIMUM, TemperatureCalculator.celsiusToKelvin(TemperatureCalculator.CELSIUS_MINIMUM), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToKelvinWithNegativeNumber() {
        assertEquals(123f, TemperatureCalculator.celsiusToKelvin(-150.15f), ACCEPTABLE_DELTA);
        assertThat(TemperatureCalculator.celsiusToKelvin(-150.15f))
            .isEqualTo(123f, Assertions.within(ACCEPTABLE_DELTA));
    }
    
    @Test
    public void testCelsiusToKelvinWithZero() {
        assertEquals(-TemperatureCalculator.CELSIUS_MINIMUM, TemperatureCalculator.celsiusToKelvin(0f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToKelvinWithPositiveNumber() {
        assertEquals(573.15f, TemperatureCalculator.celsiusToKelvin(300f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToKelvinWithInvalidNumber() {
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureCalculator.celsiusToKelvin(-650.15f);
        });
        assertEquals("Celsius value should be at least " + TemperatureCalculator.CELSIUS_MINIMUM, ex.getMessage());
    }
    
    @Test
    public void testKelvinToCelsiusWithMinimum() {
        assertEquals(TemperatureCalculator.CELSIUS_MINIMUM, TemperatureCalculator.kelvinToCelsius(TemperatureCalculator.KELVIN_MINIMUM), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testKelvinToCelsiusWithPositiveNumber() {
        assertEquals(86.1f, TemperatureCalculator.kelvinToCelsius(359.25f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testKelvinToCelsiusWithInvalidNumber() {
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureCalculator.kelvinToCelsius(-1f);
        });
        assertEquals("Kelvin value should be at least " + TemperatureCalculator.KELVIN_MINIMUM, ex.getMessage());
    }
    
    @Test
    public void testCelsiusToFahrenheitWithMinimum() {
        assertEquals(TemperatureCalculator.FAHRENHEIT_MINIMUM, TemperatureCalculator.celsiusToFahrenheit(TemperatureCalculator.CELSIUS_MINIMUM), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToFahrenheitWithNegativeNumber() {
        assertEquals(-51.07f, TemperatureCalculator.celsiusToFahrenheit(-46.15f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToFahrenheitWithZero() {
        assertEquals(32f, TemperatureCalculator.celsiusToFahrenheit(0f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToFahrenheitWithPositiveNumber() {
        assertEquals(342.392f, TemperatureCalculator.celsiusToFahrenheit(172.44f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testCelsiusToFahrenheitWithInvalidNumber() {
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureCalculator.celsiusToFahrenheit(-300);
        });
        assertEquals("Celsius value should be at least " + TemperatureCalculator.CELSIUS_MINIMUM, ex.getMessage());
    }
    
    @Test
    public void testFahrenheitToCelsiusWithMinimum() {
        assertEquals(TemperatureCalculator.CELSIUS_MINIMUM, TemperatureCalculator.fahrenheitToCelsius(TemperatureCalculator.FAHRENHEIT_MINIMUM), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToCelsiusWithNegativeNumber() {
        assertEquals(-65f, TemperatureCalculator.fahrenheitToCelsius(-85f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToCelsiusWithZero() {
        assertEquals(-17.7778f, TemperatureCalculator.fahrenheitToCelsius(0f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToCelsiusWithPositiveNumber() {
        assertEquals(60.4222f, TemperatureCalculator.fahrenheitToCelsius(140.76f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToCelsiusWithInvalidNumber() {
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureCalculator.fahrenheitToCelsius(-783f);
        });
        assertEquals("Fahrenheit value should be at least " + TemperatureCalculator.FAHRENHEIT_MINIMUM, ex.getMessage());
    }
    
    @Test
    public void testKelvinToFahrenheitWithMinimum() {
        assertEquals(TemperatureCalculator.FAHRENHEIT_MINIMUM, TemperatureCalculator.kelvinToFahrenheit(TemperatureCalculator.KELVIN_MINIMUM), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testKelvinToFahrenheitWithPositiveNumber() {
        assertEquals(554f, TemperatureCalculator.kelvinToFahrenheit(563.15f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testKelvinToFahrenheitWithInvalidNumber() {
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureCalculator.kelvinToFahrenheit(-0.005f);
        });
        assertEquals("Kelvin value should be at least " + TemperatureCalculator.KELVIN_MINIMUM, ex.getMessage());
    }
    
    @Test
    public void testFahrenheitToKelvinWithMinimum() {
        assertEquals(TemperatureCalculator.KELVIN_MINIMUM, TemperatureCalculator.fahrenheitToKelvin(TemperatureCalculator.FAHRENHEIT_MINIMUM), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToKelvinWithNegativeNumber() {
        assertEquals(89.2611f, TemperatureCalculator.fahrenheitToKelvin(-299f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToKelvinWithZero() {
        assertEquals(255.372f, TemperatureCalculator.fahrenheitToKelvin(0f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToKelvinWithPositiveNumber() {
        assertEquals(568.2333f, TemperatureCalculator.fahrenheitToKelvin(563.15f), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testFahrenheitToKelvinWithInvalidNumber() {
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            TemperatureCalculator.fahrenheitToKelvin(-742f);
        });
        assertEquals("Fahrenheit value should be at least " + TemperatureCalculator.FAHRENHEIT_MINIMUM, ex.getMessage());
    }
}
