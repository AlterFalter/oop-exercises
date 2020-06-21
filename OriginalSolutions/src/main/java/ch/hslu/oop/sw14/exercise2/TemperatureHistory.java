/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw14.exercise2;

import ch.hslu.oop.sw10.exercise1.Temperature;
import ch.hslu.oop.sw11.exercise2.TemperatureCalculator;
import ch.hslu.oop.sw12.exercise2.MaxTemperatureChangeEvent;
import ch.hslu.oop.sw12.exercise2.MaxTemperatureChangeListener;
import ch.hslu.oop.sw12.exercise2.MinTemperatureChangeEvent;
import ch.hslu.oop.sw12.exercise2.MinTemperatureChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author yannk
 */
public class TemperatureHistory extends ch.hslu.oop.sw12.exercise2.TemperatureHistory {
    
    @Override
    public float getMaxTemperatureInCelsius() {
        return (float)this.temperatures.stream()
            .mapToDouble(t -> t.getTemperatureInCelsius())
            .max()
            .orElseThrow(ArithmeticException::new);
    }
    
    public float getMinTemperatureInCelsius() {
        return (float)this.temperatures.stream()
            .mapToDouble(t -> t.getTemperatureInCelsius())
            .min()
            .orElseThrow(ArithmeticException::new);
    }
    
    public float getAverageTemperatureInCelsius() {
        return (float)this.temperatures.stream()
            .mapToDouble(t -> t.getTemperatureInCelsius())
            .average()
            .orElseThrow(ArithmeticException::new);
    }
}
