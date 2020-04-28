/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08.exercise2;

import java.util.Objects;

/**
 *
 * @author yannk
 */
public class Element implements Comparable<Element> {
    private String name;
    
    private String abbreviation;
    
    // Schmelzpunkt
    private float meltingPointInCelsius;
    
    // Siedepunkt
    private float boilingPointInCelsius;
    
    public Element(
            String name,
            String abbreviation,
            float meltingPointInCelsius,
            float boilingPointInCelsius) {
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
    
    public String getState(float temperatureInCelsius) {
        if (temperatureInCelsius < this.meltingPointInCelsius) {
            return "fest";
        }
        else if (temperatureInCelsius < this.boilingPointInCelsius) {
            return "fluessig";
        }
        else {
            return "gasfoermig";
        }
    }
    
    @Override
    public String toString() {
        return "Class: " + Element.class.getName() +
               " - Name: " + this.name +
               " | Abbreviation: " + this.abbreviation +
               " | melting point: " + this.meltingPointInCelsius + "°C" +
               " | boiling point: " + this.boilingPointInCelsius + "°C";
    }
    
    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        // also makes null check
        else if (!(other instanceof Element)) {
            return false;
        }
        else {
            Element otherElement = (Element) other;
            return otherElement.name.equals(this.name) &&
                   otherElement.abbreviation.equals(this.abbreviation) &&
                   otherElement.meltingPointInCelsius == this.meltingPointInCelsius &&
                   otherElement.boilingPointInCelsius == this.boilingPointInCelsius;
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.abbreviation, this.meltingPointInCelsius, this.boilingPointInCelsius);
    }
    
    @Override
    public int compareTo(Element other) {
        return this.name.compareTo(other.name);
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
