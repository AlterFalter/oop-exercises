/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk13.exercise2;

import java.util.Comparator;

/**
 *
 * @author yannk
 */
public class Temperature implements Comparable<Temperature>{
    public static final Comparator<Temperature> temperatureComparator = (t1, t2) -> Float.compare(t1.getTemperatureInKelvin(), t2.getTemperatureInKelvin());
    private float temperatureInKelvin;
    
    public Temperature(float temperatureInKelvin) {
        this.temperatureInKelvin = temperatureInKelvin;
    }
    
    public float getTemperatureInKelvin() {
        return this.temperatureInKelvin;
    }

    @Override
    public int compareTo(Temperature other) {
        int compare = temperatureComparator.compare(this, other);
        return compare;
    }
    
    public static int compare(Temperature t1, Temperature t2) {
        return temperatureComparator.compare(t1, t2);
    }
    
    @Override
    public String toString() {
        return "Temperature - in Kelvin: " + this.temperatureInKelvin;
    }
}
