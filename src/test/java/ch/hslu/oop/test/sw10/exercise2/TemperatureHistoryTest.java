/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw10.exercise2;

import ch.hslu.oop.sw10.exercise1.Temperature;
import ch.hslu.oop.sw10.exercise2.TemperatureHistory;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author yannk
 */
public class TemperatureHistoryTest {
    private static final float ACCEPTABLE_DELTA = 0.01f;
    
    @Test
    public void testSizeWhenEmpty() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertEquals(0, temperatureHistory.getCount());
    }
    
    @Test
    public void testAddAndSizeWithOne() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(14.44f));
        assertEquals(1, temperatureHistory.getCount());
    }
    
    @Test
    public void testAddAndSizeWithMultiple() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(14.44f));
        temperatureHistory.add(new Temperature(76.12f));
        temperatureHistory.add(new Temperature(168f));
        assertEquals(3, temperatureHistory.getCount());
    }
    
    @Test
    public void testClearWhenEmpty() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
    }
    
    @Test
    public void testClearWithMultiple() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(1f));
        temperatureHistory.add(new Temperature(93.15f));
        temperatureHistory.add(new Temperature(230f));
        
        temperatureHistory.clear();
        assertEquals(0, temperatureHistory.getCount());
    }
    
    @Test
    public void testIsEmptyWhenEmpty() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertTrue(temperatureHistory.isEmpty());
    }
    
    @Test
    public void testIsEmptyWithOne() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(41.15f));
        assertFalse(temperatureHistory.isEmpty());
    }
    
    @Test
    public void testIsEmptyWithMultiple() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(84f));
        temperatureHistory.add(new Temperature(573.5f));
        temperatureHistory.add(new Temperature(857.04f));
        assertFalse(temperatureHistory.isEmpty());
    }
    
    @Test
    public void testGetMaxTemperatureInCelsiusWhenEmpty() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertThrows(Exception.class, () -> temperatureHistory.getMaxTemperatureInCelsius());
    }
    
    @Test
    public void testGetMaxTemperatureInCelsiusWithOne() throws Exception {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(305.15f));
        assertEquals(32f, temperatureHistory.getMaxTemperatureInCelsius());
    }
    
    @Test
    public void testGetMaxTemperatureInCelsiusWithMultiple() throws Exception{
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(188.8888f));
        temperatureHistory.add(new Temperature(95f));
        temperatureHistory.add(new Temperature(273.15f));
        assertEquals(0f, temperatureHistory.getMaxTemperatureInCelsius()); 
    }
    
    @Test
    public void testGetMinTemperatureInCelsiusWhenEmpty() {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertThrows(Exception.class, () -> temperatureHistory.getMinTemperatureInCelsius());
    }
    
    @Test
    public void testGetMinTemperatureInCelsiusWithOne() throws Exception {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(305.15f));
        assertEquals(32f, temperatureHistory.getMinTemperatureInCelsius());
    }
    
    @Test
    public void testGetMinTemperatureInCelsiusWithMultiple() throws Exception{
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(188.8888f));
        temperatureHistory.add(new Temperature(95f));
        temperatureHistory.add(new Temperature(273.15f));
        assertEquals(-178.15f, temperatureHistory.getMinTemperatureInCelsius()); 
    }
    
    @Test
    public void testGetAverageTemperatureInCelsiusWhenEmpty() throws Exception {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        assertThrows(Exception.class, () -> temperatureHistory.getAverageTemperatureInCelsius());
    }
    
    @Test
    public void testGetAverageTemperatureInCelsiusWithOne() throws Exception {
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(305.15f));
        assertEquals(32, temperatureHistory.getAverageTemperatureInCelsius());
    }
    
    @Test
    public void testGetAverageTemperatureInCelsiusWithMultiple() throws Exception{
        TemperatureHistory temperatureHistory = new TemperatureHistory();
        temperatureHistory.add(new Temperature(188.15f));
        temperatureHistory.add(new Temperature(95f));
        temperatureHistory.add(new Temperature(273.15f));
        assertEquals(-87.71, temperatureHistory.getAverageTemperatureInCelsius(), ACCEPTABLE_DELTA); 
    }
}
