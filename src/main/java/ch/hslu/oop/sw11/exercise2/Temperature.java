/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw11.exercise2;

/**
 *
 * @author yannk
 */
public class Temperature extends ImmutableTemperature {
    private Temperature(float temperatureInKelvin) {
        super(temperatureInKelvin);
    }
    
    public Temperature(float temperatureInKelvin, TemperatureUnit temperatureUnit) {
        super(temperatureInKelvin, temperatureUnit);
    }
    
    public final void setTemperature(float temperature, TemperatureUnit temperatureUnit) {
        switch (temperatureUnit) {
            case KELVIN:
                this.setTemperatureWithKelvin(temperature);
                break;
            case CELSIUS:
                this.setTemperatureWithCelsius(temperature);
                break;
            case FAHRENHEIT:
                this.setTemperatureWithFahrenheit(temperature);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported temperature unit.");
        }
    }
    
    public final void changeTemperature(float temperature, TemperatureUnit temperatureUnit) {
        switch (temperatureUnit) {
            case KELVIN:
                this.changeTemperatureWithKelvin(temperature);
                break;
            case CELSIUS:
                this.changeTemperatureWithCelsius(temperature);
                break;
            case FAHRENHEIT:
                this.changeTemperatureWithFahrenheit(temperature);
                break;
            default:
                throw new UnsupportedOperationException("Unsupported temperature unit.");
        }
    }
    
    public final void setTemperatureWithKelvin(float newTemperatureInKelvin) {
        if (newTemperatureInKelvin >= 0) {
            this.temperatureInKelvin = newTemperatureInKelvin;
        }
        else {
            throw new IllegalArgumentException("Temperature value can't be under 0°K.");
        }
    }
    
    public final void changeTemperatureWithKelvin(float temperatureChangeInKelvin) {
        this.temperatureInKelvin += temperatureChangeInKelvin;
    }
    
    public final void setTemperatureWithCelsius(float newTemperatureInCelsius) {
        this.temperatureInKelvin = TemperatureCalculator.celsiusToKelvin(newTemperatureInCelsius);
    }
    
    public final void changeTemperatureWithCelsius(float temperatureChangeInCelsius) {
        float newTemperatureInCelsius = this.getTemperatureInCelsius() + temperatureChangeInCelsius;
        this.setTemperatureWithCelsius(newTemperatureInCelsius);
    }
    
    public final void setTemperatureWithFahrenheit(float newTemperatureInFahrenheit) {
        this.temperatureInKelvin = fahrenheitToKelvin(newTemperatureInFahrenheit);
    }
    
    public final void changeTemperatureWithFahrenheit(float temperatureChangeInFahrenheit) {
        float newTemperatureInFahrenheit = this.getTemperatureInFahrenheit() + temperatureChangeInFahrenheit;
        this.setTemperatureWithFahrenheit(newTemperatureInFahrenheit);
    }
    
    public static Temperature createFromKelvin(float temperatureInKelvin) {
        return new Temperature(temperatureInKelvin, TemperatureUnit.KELVIN);
        // alternative
        //return new Temperature(temperatureInKelvin);
    }
    
    public static Temperature createFromCelsius(float temperatureInCelsius) {
        return new Temperature(temperatureInCelsius, TemperatureUnit.CELSIUS);
        // alternative
        //return new Temperature(celsiusToKelvin(temperatureInCelsius));
    }
    
    public static Temperature createFromFahrenheit(float temperatureInFahrenheit) {
        return new Temperature(temperatureInFahrenheit, TemperatureUnit.FAHRENHEIT);
        // alternative
        //return new Temperature(fahrenheitToKelvin(temperatureInFahrenheit));
    }
}
