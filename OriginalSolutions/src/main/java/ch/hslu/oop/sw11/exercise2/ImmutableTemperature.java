/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11.exercise2;

import java.util.Objects;

/**
 * Temperature class without any setter methods.
 * doesn't inherit from TemperatureCalculator because it would lead to a
 * stronger dependence between the classes and it could be used wrongly
 * in 3rd classes, so they could call static calculator methods over ImmutableTemperature
 * @author yannk
 */
public class ImmutableTemperature implements Comparable<ImmutableTemperature> {
    protected float temperatureInKelvin;
    
    protected ImmutableTemperature(float temperatureInKelvin) {
        this.temperatureInKelvin = temperatureInKelvin;
    }
    
    public ImmutableTemperature(float temperature, TemperatureUnit temperatureUnit) {
        switch (temperatureUnit) {
            case KELVIN:
                this.temperatureInKelvin = temperature;
                break;
            case CELSIUS:
                this.temperatureInKelvin = TemperatureCalculator.celsiusToKelvin(temperature);
                break;
            case FAHRENHEIT:
                this.temperatureInKelvin = TemperatureCalculator.fahrenheitToKelvin(temperature);
                break;
        }
    }
    
    public final float getTemperature(TemperatureUnit temperatureUnit) {
        switch (temperatureUnit) {
            case KELVIN:
                return this.getTemperatureInKelvin();
            case CELSIUS:
                return this.getTemperatureInCelsius();
            case FAHRENHEIT:
                return this.getTemperatureInFahrenheit();
            default:
                throw new UnsupportedOperationException("Unsupported temperature unit");
        }
    }
    
    public final float getTemperatureInKelvin() {
        return this.temperatureInKelvin;
    }
    
    public final float getTemperatureInCelsius() {
        return TemperatureCalculator.kelvinToCelsius(this.temperatureInKelvin);
    }
    
    public final float getTemperatureInFahrenheit() {
        return TemperatureCalculator.kelvinToFahrenheit(this.temperatureInKelvin);
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
        else if (!(other instanceof ImmutableTemperature)) {
            return false;
        }
        else {
            ImmutableTemperature otherTemperature = (ImmutableTemperature) other;
            return otherTemperature.temperatureInKelvin == this.temperatureInKelvin;
            // return Float.compare(otherTemperature.temperatureInCelsius, this.temperatureInCelsius) == 0;
        }
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.temperatureInKelvin);
    }

    @Override
    public final int compareTo(ImmutableTemperature other) {
        return Float.compare(this.temperatureInKelvin, other.temperatureInKelvin);
    }
    
    /// formel Umsetzung ist performanter (besser bei vielen Umrechmungen)
    /// Umsetzung mit 2 Methodeaufrufen kann sich lohnen bei sehr vielen Einheiten oder sehr wenigen Aufrufen (Testing), 
    /// kann auch Genauigkeitsverlust geben
    /// --> res = FahrenheitToCelsius(1234); return CelsiusToKelvin(res);
    public final static float fahrenheitToKelvin(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit + 459.67f) / 1.8f;
    }
    
    public static ImmutableTemperature createFromKelvin(float temperatureInKelvin) {
        return new ImmutableTemperature(temperatureInKelvin, TemperatureUnit.KELVIN);
        // alternative
        //return new ImmutableTemperature(temperatureInKelvin);
    }
    
    public static ImmutableTemperature createFromCelsius(float temperatureInCelsius) {
        return new ImmutableTemperature(temperatureInCelsius, TemperatureUnit.CELSIUS);
        // alternative
        //return new Temperature(celsiusToKelvin(temperatureInCelsius));
    }
    
    public static ImmutableTemperature createFromFahrenheit(float temperatureInFahrenheit) {
        return new ImmutableTemperature(temperatureInFahrenheit, TemperatureUnit.FAHRENHEIT);
        // alternative
        //return new ImmutableTemperature(fahrenheitToKelvin(temperatureInFahrenheit));
    }
}
