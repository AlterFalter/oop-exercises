/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10.exercise3;

import java.util.Objects;

/**
 *
 * @author yannk
 */
public class Element {
    private final String name;
    
    private final String abbreviation;
    
    // Schmelzpunkt
    private final float meltingPointInCelsius;
    
    // Siedepunkt
    private final float boilingPointInCelsius;
    
    public Element(
            String name,
            String abbreviation,
            float meltingPointInCelsius,
            float boilingPointInCelsius) {
        if (name == null) {
            name = "";
        }
        this.name = name;
        if (abbreviation == null) {
            abbreviation = "";
        }
        this.abbreviation = abbreviation;
        this.meltingPointInCelsius = meltingPointInCelsius;
        this.boilingPointInCelsius = boilingPointInCelsius;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getAbbreviation() {
        return this.abbreviation;
    }
    
    public float getMeltingPointInCelsius() {
        return this.meltingPointInCelsius;
    }
    
    public float getBoilingPointInCelsius() {
        return this.boilingPointInCelsius;
    }
    
    public AggregatePhase getAggregatePhase(float temperatureInCelsius) {
        if (temperatureInCelsius < this.meltingPointInCelsius) {
            return AggregatePhase.SOLID;
        }
        else if (temperatureInCelsius < this.boilingPointInCelsius) {
            return AggregatePhase.LIQUID;
        }
        else {
            return AggregatePhase.GAS;
        }
    }
    
    public String printAggregatePhase(float temperatureInCelsius) {
        return this.name + " is in the " +
            this.getAggregatePhase(temperatureInCelsius) + " state with the temperature: " +
            temperatureInCelsius + " °C";
    }
    
    public String printAggregatePhaseInGerman(float temperatureInCelsius) {
        return this.name + " ist bei " +
            temperatureInCelsius + "°C " +
            this.getAggregatePhase(temperatureInCelsius).getGermanTranslation();
    }
    
    @Override
    public String toString() {
        return "Class: " + Element.class.getSimpleName() +
               " - Name: " + this.name +
               " | Abbreviation: " + this.abbreviation +
               " | melting point: " + this.meltingPointInCelsius + "°C" +
               " | boiling point: " + this.boilingPointInCelsius + "°C";
    }
    
    @Override
    public final boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        // also makes null check
        else if (!(other instanceof Element)) {
            return false;
        }
        else {
            Element otherElement = (Element) other;
            return ((this.name == null && otherElement.name == null) || (this.name != null && this.name.equals(otherElement.name))) &&
                   ((this.abbreviation == null && otherElement.abbreviation == null) || (this.abbreviation != null && this.abbreviation.equals(otherElement.abbreviation))) &&
                   new Float(this.meltingPointInCelsius).equals(otherElement.meltingPointInCelsius) &&
                   new Float(this.boilingPointInCelsius).equals(otherElement.boilingPointInCelsius);
        }
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.name, this.abbreviation, this.meltingPointInCelsius, this.boilingPointInCelsius);
    }
    
    public static Element[] getElements() {
        Element nitrogen = new Element("Stickstoff", "N", -210.1f, -196f);
        Element mercury = new Element("Quecksilber", "Hg", -38.829f, 356.73f);
        Element lead = new Element("Blei", "Pb", 327.46f, 1749f);
        
        return new Element[] {
            nitrogen,
            mercury,
            lead
        };
    }
}
