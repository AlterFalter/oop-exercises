/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw11.exercise2;

import ch.hslu.oop.sw11.exercise2.Temperature;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author yannk
 */
public class TemperatureTest {
    private static final float ACCEPTABLE_DELTA = 0.01f;
    
    @Test
    public void testChangeTemperatureWithKelvin() {
        Temperature temperature = Temperature.createFromKelvin(283.15f);
        temperature.changeTemperatureWithKelvin(10);
        assertEquals(293.15f, temperature.getTemperatureInKelvin(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testChangeTemperatureWithKelvinWithNegativeNumber() {
        Temperature temperature = Temperature.createFromKelvin(283.15f);
        temperature.changeTemperatureWithKelvin(-7.15f);
        assertEquals(276f, temperature.getTemperatureInKelvin(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testChangeTemperatureWithCelsius() {
        Temperature temperature = Temperature.createFromKelvin(273.15f);
        temperature.changeTemperatureWithCelsius(15f);
        assertEquals(15f, temperature.getTemperatureInCelsius(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testChangeTemperatureWithCelsiusWithNegativeNumber() {
        Temperature temperature = Temperature.createFromKelvin(273.15f);
        temperature.changeTemperatureWithCelsius(-94f);
        assertEquals(-94f, temperature.getTemperatureInCelsius(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testChangeTemperatureWithFahrenheit() {
        Temperature temperature = Temperature.createFromKelvin(300f);
        temperature.changeTemperatureWithFahrenheit(5.67f);
        assertEquals(86f, temperature.getTemperatureInFahrenheit(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testChangeTemperatureWithFahrenheitWithNegativeNumber() {
        Temperature temperature = Temperature.createFromKelvin(300f);
        temperature.changeTemperatureWithFahrenheit(-10.33f);
        assertEquals(70f, temperature.getTemperatureInFahrenheit(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testSetTemperatureWithKelvin() {
        Temperature temperature = Temperature.createFromKelvin(0f);
        temperature.setTemperatureWithKelvin(93f);
        assertEquals(93f, temperature.getTemperatureInKelvin(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testSetTemperatureWithCelsius() {
        Temperature temperature = Temperature.createFromKelvin(0f);
        temperature.setTemperatureWithCelsius(-34f);
        assertEquals(-34f, temperature.getTemperatureInCelsius(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testSetTemperatureWithFahrenheit() {
        Temperature temperature = Temperature.createFromKelvin(0f);
        temperature.setTemperatureWithFahrenheit(48.33f);
        assertEquals(48.33f, temperature.getTemperatureInFahrenheit(), ACCEPTABLE_DELTA);
    }
}
