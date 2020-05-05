/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10.exercise1;

import java.util.Objects;

/**
 *
 * @author yannk
 */
public final class Temperature implements Comparable<Temperature> {
    private static final float CELSIUS_KELVIN_OFFSET = 273.15f;
    private float temperatureInKelvin;
    
    public Temperature(float temperatureInKelvin) {
        this.temperatureInKelvin = temperatureInKelvin;
    }
    
    public final float getTemperatureInCelsius() {
        return kelvinToCelsius(this.temperatureInKelvin);
    }
    
    public final void setTemperatureWithCelsius(float newTemperatureInCelsius) {
        this.temperatureInKelvin = celsiusToKelvin(newTemperatureInCelsius);
    }
    
    public final void changeTemperatureWithCelsius(float temperatureChangeInCelsius) {
        float newTemperatureInCelsius = this.getTemperatureInCelsius() + temperatureChangeInCelsius;
        this.setTemperatureWithCelsius(newTemperatureInCelsius);
    }
    
    public final float getTemperatureInKelvin() {
        return this.temperatureInKelvin;
    }
    
    public final void setTemperatureWithKelvin(float newTemperatureInKelvin) {
        this.temperatureInKelvin = newTemperatureInKelvin;
    }
    
    public final void changeTemperatureWithKelvin(float temperatureChangeInKelvin) {
        this.temperatureInKelvin += temperatureChangeInKelvin;
    }
    
    public final float getTemperatureInFahrenheit() {
        return kelvinToFahrenheit(this.temperatureInKelvin);
    }
    
    public final void setTemperatureWithFahrenheit(float newTemperatureInFahrenheit) {
        this.temperatureInKelvin = fahrenheitToKelvin(newTemperatureInFahrenheit);
    }
    
    public final void changeTemperatureWithFahrenheit(float temperatureChangeInFahrenheit) {
        float newTemperatureInFahrenheit = this.getTemperatureInFahrenheit() + temperatureChangeInFahrenheit;
        this.setTemperatureWithFahrenheit(newTemperatureInFahrenheit);
    }
    
    @Override
    public final String toString() {
        return "Class: " + Temperature.class.getSimpleName() + 
               " | Temperature in °C: " + this.getTemperatureInCelsius() +
               " | in °K: " + this.getTemperatureInKelvin() +
               " | in °F: " + this.getTemperatureInFahrenheit();
    }
    
    @Override
    public final boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        // also makes null check
        else if (!(other instanceof Temperature)) {
            return false;
        }
        else {
            Temperature otherTemperature = (Temperature) other;
            return otherTemperature.temperatureInKelvin == this.temperatureInKelvin;
            // return Float.compare(otherTemperature.temperatureInCelsius, this.temperatureInCelsius) == 0;
        }
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.temperatureInKelvin);
    }

    @Override
    public final int compareTo(Temperature other) {
        return Float.compare(this.temperatureInKelvin, other.temperatureInKelvin);
    }
    
    public final static float celsiusToKelvin(float temperatureInCelsius) {
        return temperatureInCelsius + CELSIUS_KELVIN_OFFSET;
    }
    
    public final static float kelvinToCelsius(float temperatureInKelvin) {
        return temperatureInKelvin - CELSIUS_KELVIN_OFFSET;
    }
    
    public final static float celsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }
    
    public final static float fahrenheitToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32f) / 1.8f;
    }
    
    public final static float kelvinToFahrenheit(float temperatureInKelvin) {
        return temperatureInKelvin * 1.8f - 459.67f;
    }
    
    /// formel Umsetzung ist performanter (besser bei vielen Umrechmungen)
    /// Umsetzung mit 2 Methodeaufrufen kann sich lohnen bei sehr vielen Einheiten oder sehr wenigen Aufrufen (Testing), 
    /// kann auch Genauigkeitsverlust geben
    /// --> res = FahrenheitToCelsius(1234); return CelsiusToKelvin(res);
    public final static float fahrenheitToKelvin(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit + 459.67f) / 1.8f;
    }
}
