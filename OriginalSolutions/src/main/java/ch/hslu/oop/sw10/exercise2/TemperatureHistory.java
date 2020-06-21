/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10.exercise2;

import ch.hslu.oop.sw10.exercise1.Temperature;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author yannk
 */
public class TemperatureHistory {
    // final "betoniert" Referenz
    protected final Collection<Temperature> temperatures;
    
    public TemperatureHistory() {
        this.temperatures = new ArrayList<Temperature>();
    }
    
    public void add(Temperature temperature) {
        this.temperatures.add(temperature);
    }
    
    public void clear() {
        this.temperatures.clear();
    }
    
    public int getCount() {
        return this.temperatures.size();
    }
    
    public boolean isEmpty() {
        return this.temperatures.isEmpty();
    }
    
    public float getMaxTemperatureInCelsius() throws Exception {
        if (this.isEmpty()) {
            throw new Exception();
        }
        else {
            // already sorts because of compareTo
            return Collections.max(temperatures).getTemperatureInCelsius();
        }
    }
    
    public float getMinTemperatureInCelsius() throws Exception {
        if (this.isEmpty()) {
            throw new Exception();
        }
        return Collections.min(temperatures).getTemperatureInCelsius();
        //return Collections.min(this.getTemperaturesInCelsius());
    }
    
    public float getAverageTemperatureInCelsius() throws Exception {
        if (this.isEmpty()) {
            throw new Exception();
        }
        
        float sum = 0;
        for (Temperature temperature : this.temperatures) {
            sum += temperature.getTemperatureInCelsius();
        }
        float average = sum / this.getCount();
        
        return average;
   }
}
