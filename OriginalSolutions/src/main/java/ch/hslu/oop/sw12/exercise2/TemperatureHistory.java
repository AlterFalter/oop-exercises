/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise2;

import ch.hslu.oop.sw10.exercise1.Temperature;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author yannk
 */
public class TemperatureHistory extends ch.hslu.oop.sw10.exercise2.TemperatureHistory {
    private final List<MinTemperatureChangeListener> minimumListeners = new ArrayList<>();
    private final List<MaxTemperatureChangeListener> maximumListeners = new ArrayList<>();
    
    public TemperatureHistory() {
        super();
    }
    
    @Override
    public void add(Temperature temperature) {
        super.add(temperature);
        try {
            if (this.getCount() > 1) {
                float currentMinTemperatureInKelvin = Temperature.celsiusToKelvin(this.getMinTemperatureInCelsius());
                if (Collections.frequency(this.temperatures, new Temperature(currentMinTemperatureInKelvin)) == 1 &&
                    currentMinTemperatureInKelvin == temperature.getTemperatureInKelvin()) {
                    final MinTemperatureChangeEvent event = new MinTemperatureChangeEvent(this, temperature.getTemperatureInCelsius());
                    this.fireMinimumChangeEvent(event);
                }
                else {
                    float currentMaxTemperatureInKelvin = Temperature.celsiusToKelvin(this.getMaxTemperatureInCelsius());
                    if (Collections.frequency(this.temperatures, new Temperature(currentMaxTemperatureInKelvin)) == 1 &&
                        currentMaxTemperatureInKelvin == temperature.getTemperatureInKelvin()) {
                        final MaxTemperatureChangeEvent event = new MaxTemperatureChangeEvent(this, temperature.getTemperatureInCelsius());
                        this.fireMaximumChangeEvent(event);
                    }
                }
            }
            else {
                final MinTemperatureChangeEvent minEvent = new MinTemperatureChangeEvent(this, temperature.getTemperatureInCelsius());
                this.fireMinimumChangeEvent(minEvent);
                final MaxTemperatureChangeEvent maxEvent = new MaxTemperatureChangeEvent(this, temperature.getTemperatureInCelsius());
                this.fireMaximumChangeEvent(maxEvent);
            }
        }
        catch (Exception ex) {
        }
    }
    
    @Override
    public String toString() {
        String text = "Class: " + TemperatureHistory.class.getSimpleName();
        try {
            text += " | Avg: " + this.getAverageTemperatureInCelsius() + "°C" +
                    " | Min: " + this.getMinTemperatureInCelsius() + "°C" +
                    " | Max: " + this.getMaxTemperatureInCelsius() + "°C";
        }
        catch (Exception ex) {
            System.out.println("Error occured in toString()");
            if (this.getCount() == 0) {
                System.out.println("No items in TemperatureHistory");
            }
        }
        return text;
    }
    
    public void addMinimumChangeListener(final MinTemperatureChangeListener listener) {
        this.minimumListeners.add(listener);
    }
    
    private void fireMinimumChangeEvent(final MinTemperatureChangeEvent event) {
        for (MinTemperatureChangeListener minimumListener : this.minimumListeners) {
            minimumListener.minTemperatureChanged(event);
        }
    }
    
    public void addMaximumChangeListener(final MaxTemperatureChangeListener listener) {
        this.maximumListeners.add(listener);
    }
    
    private void fireMaximumChangeEvent(final MaxTemperatureChangeEvent event) {
        for (MaxTemperatureChangeListener maximumListener : this.maximumListeners) {
            maximumListener.maxTemperatureChanged(event);
        }
    }
}
