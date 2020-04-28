/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08.exercise1;

import java.util.Objects;

/**
 *
 * @author yannk
 */
public class Temperature {
    private float temperatureInCelsius;
    
    public Temperature() {
        this.temperatureInCelsius = 0;
    }
    
    public Temperature(float temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }
    
    public float getTemperatureInCelsius() {
        return this.temperatureInCelsius;
    }
    
    public void setTemperatureWithCelsius(float newTemperatureInCelsius) {
        this.temperatureInCelsius = newTemperatureInCelsius;
    }
    
    public void changeTemperatureWithCelsius(float temperatureChangeInCelsius) {
        this.temperatureInCelsius += temperatureChangeInCelsius;
    }
    
    public float getTemperatureInKelvin() {
        return celsiusToKelvin(this.temperatureInCelsius);
    }
    
    public void setTemperatureWithKelvin(float newTemperatureInKelvin) {
        this.temperatureInCelsius = kelvinToCelsius(newTemperatureInKelvin);
    }
    
    public void changeTemperatureWithKelvin(float temperatureChangeInKelvin) {
        float newTemperatureInKelvin = this.getTemperatureInKelvin() + temperatureChangeInKelvin;
        this.setTemperatureWithKelvin(newTemperatureInKelvin);
    }
    
    public float getTemperatureInFahrenheit() {
        return celsiusToFahrenheit(this.temperatureInCelsius);
    }
    
    public void setTemperatureWithFahrenheit(float newTemperatureInFahrenheit) {
        this.temperatureInCelsius = fahrenheitToCelsius(newTemperatureInFahrenheit);
    }
    
    public void changeTemperatureWithFahrenheit(float temperatureChangeInFahrenheit) {
        float newTemperatureInFahrenheit = this.getTemperatureInFahrenheit() + temperatureChangeInFahrenheit;
        this.setTemperatureWithFahrenheit(newTemperatureInFahrenheit);
    }
    
    @Override
    public String toString() {
        return "Class: " + Temperature.class.getName() + " | Temperature in °C: " + this.getTemperatureInCelsius();
    }
    
    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        // also makes null check
        else if (!(other instanceof Temperature)) {
            return false;
        }
        else {
            Temperature otherTemperature = (Temperature) other;
            return otherTemperature.temperatureInCelsius == this.temperatureInCelsius;
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.temperatureInCelsius);
    }
    
    public static float celsiusToKelvin(float temperatureInCelsius) {
        return temperatureInCelsius + 273.15f;
    }
    
    public static float kelvinToCelsius(float temperatureInKelvin) {
        return temperatureInKelvin - 273.15f;
    }
    
    public static float celsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }
    
    public static float fahrenheitToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32f) / 1.8f;
    }
    
    public static float kelvinToFahrenheit(float temperatureInKelvin) {
        return temperatureInKelvin * 1.8f - 459.67f;
    }
    
    /// formel Umsetzung ist performanter (besser bei vielen Umrechmungen)
    /// Umsetzung mit 2 Methodeaufrufen kann sich lohnen bei sehr vielen Einheiten oder sehr wenigen Aufrufen (Testing), 
    /// kann auch Genauigkeitsverlust geben
    /// --> res = FahrenheitToCelsius(1234); return CelsiusToKelvin(res);
    public static float fahrenheitToKelvin(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit + 459.67f) / 1.8f;
    }
    
    public String getStateFromElementByCurrentTemperature(String elementName) {
        for (Element element : Element.getElements()) {
            if (element.getName() == elementName || element.getAbbreviation() == elementName) {
                return element.getState(this.temperatureInCelsius);
            }
        }
        return null;
    }
}
