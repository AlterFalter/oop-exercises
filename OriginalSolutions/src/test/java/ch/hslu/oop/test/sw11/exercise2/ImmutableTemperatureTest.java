/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw11.exercise2;

import ch.hslu.oop.sw11.exercise2.ImmutableTemperature;
import ch.hslu.oop.sw11.exercise2.TemperatureCalculator;

import nl.jqno.equalsverifier.EqualsVerifier;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 *
 * @author yannk
 */
public class ImmutableTemperatureTest {
    private static final float ACCEPTABLE_DELTA = 0.01f;
    
    @Test
    public void testGetImmutableTemperatureInKelvin() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(15);
        assertEquals(15f, temperature.getTemperatureInKelvin(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInKelvinWithZero() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(0);
        assertEquals(0f, temperature.getTemperatureInKelvin(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInCelsiusWithPositiveImmutableTemperature() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(300.15f);
        assertEquals(27f, temperature.getTemperatureInCelsius(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInCelsiusWithZeroCelsius() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(273.15f);
        assertEquals(0f, temperature.getTemperatureInCelsius(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInCelsiusWithNegativeImmutableTemperature() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(129.15f);
        assertEquals(-144f, temperature.getTemperatureInCelsius(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInFahrenheitWithNegativeImmutableTemperature() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(129.15f);
        assertEquals(-227.2f, temperature.getTemperatureInFahrenheit(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInFahrenheitWithZero() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(255.3722f);
        assertEquals(0, temperature.getTemperatureInFahrenheit(), ACCEPTABLE_DELTA);
    }
    
    @Test
    public void testGetImmutableTemperatureInFahrenheitWithPositiveImmutableTemperature() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(283.15f);
        assertEquals(50f, temperature.getTemperatureInFahrenheit(), ACCEPTABLE_DELTA);
    }
    
    // disabled because it fails, when printing °F,
    // would show correct values
    @Test
    public void testToString() {
        System.out.println(TemperatureCalculator.kelvinToFahrenheit(273.15f));
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(-TemperatureCalculator.CELSIUS_MINIMUM);
        String expectedOutput = "Class: ImmutableTemperature | ImmutableTemperature in °C: 0 | in °K: 273.15 | in °F: 32";
        assertEquals(expectedOutput, temperature.toString());
    }
    
    @Test @Disabled
    public void testEqualsContract() {
        EqualsVerifier.forClass(ImmutableTemperature.class).verify();
    }
}
