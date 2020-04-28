/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10.exercise2;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author yannk
 */
public class TemperatureHistory {
    private Collection<Temperature> temperatures;
    
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
    
    public Collection<Float> getTemperaturesInCelsius() {
//        Collection<Float> temperaturesInCelsius = new ArrayList<Float>();
//        this.temperatures.forEach(t -> temperaturesInCelsius.add(t));
//        return temperaturesInCelsius;
        return this.temperatures
            .stream()
            .map(t -> t.getTemperatureInCelsius())
            .collect(Collectors.toList());
    }
    
    public float getMaxTemperatureInCelsius() {
        return Collections.max(this.getTemperaturesInCelsius());
    }
    
    public float getMinTemperatureInCelsius() {
        return Collections.min(this.getTemperaturesInCelsius());
    }
    
    public float getAverageTemperatureInCelsius() {
        return (float)this.getTemperaturesInCelsius()
            .stream()
            .mapToDouble(t -> t)
            .average();
   }
}
