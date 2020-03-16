/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw02.exercise1;

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
    
    public float GetTemperatureInCelsius() {
        return this.temperatureInCelsius;
    }
    
    public void SetTemperatureWithCelsius(float newTemperatureInCelsius) {
        this.temperatureInCelsius = newTemperatureInCelsius;
    }
    
    public void ChangeTemperatureWithCelsius(float temperatureChangeInCelsius) {
        this.temperatureInCelsius += temperatureChangeInCelsius;
    }
    
    public float GetTemperatureInKelvin() {
        return CelsiusToKelvin(this.temperatureInCelsius);
    }
    
    public void SetTemperatureWithKelvin(float newTemperatureInKelvin) {
        this.temperatureInCelsius = KelvinToCelsius(newTemperatureInKelvin);
    }
    
    public void ChangeTemperatureWithKelvin(float temperatureChangeInKelvin) {
        float newTemperatureInKelvin = this.GetTemperatureInKelvin() + temperatureChangeInKelvin;
        this.SetTemperatureWithKelvin(newTemperatureInKelvin);
    }
    
    public float GetTemperatureInFahrenheit() {
        return CelsiusToFahrenheit(this.temperatureInCelsius);
    }
    
    public void SetTemperatureWithFahrenheit(float newTemperatureInFahrenheit) {
        this.temperatureInCelsius = FahrenheitToCelsius(newTemperatureInFahrenheit);
    }
    
    public void ChangeTemperatureWithFahrenheit(float temperatureChangeInFahrenheit) {
        float newTemperatureInFahrenheit = this.GetTemperatureInFahrenheit() + temperatureChangeInFahrenheit;
        this.SetTemperatureWithFahrenheit(newTemperatureInFahrenheit);
    }
    
    public static float CelsiusToKelvin(float temperatureInCelsius) {
        return temperatureInCelsius + 273.15f;
    }
    
    public static float KelvinToCelsius(float temperatureInKelvin) {
        return temperatureInKelvin - 273.15f;
    }
    
    public static float CelsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }
    
    public static float FahrenheitToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - 32f) / 1.8f;
    }
    
    public static float KelvinToFahrenheit(float temperatureInKelvin) {
        return temperatureInKelvin * 1.8f - 459.67f;
    }
    
    /// formel Umsetzung ist performanter (besser bei vielen Umrechmungen)
    /// Umsetzung mit 2 Methodeaufrufen kann sich lohnen bei sehr vielen Einheiten oder sehr wenigen Aufrufen (Testing), 
    /// kann auch Genauigkeitsverlust geben
    /// --> res = FahrenheitToCelsius(1234); return CelsiusToKelvin(res);
    public static float FahrenheitToKelvin(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit + 459.67f) / 1.8f;
    }
}
