/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Student
 */
public class Toner implements GenerationCompatibilityCheckable {
    private String color;
    private final Set<Generation> compatibleGenerations;
    
    public Toner() {
        this.color = "black";
        this.compatibleGenerations = new HashSet<>();
        this.compatibleGenerations.add(Generation.G1);
        this.compatibleGenerations.add(Generation.G2);
    }
    
    public Toner(String color) {
        this();
        this.color = color;
    }
    
    
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String newColor) {
        this.color = newColor;
    }
    
    @Override
    public String toString() {
        return "Toner[color=" + this.color + "]";
    }

    @Override
    public boolean isCompatibleTo(Generation to) {
        return this.compatibleGenerations.contains(to);
    }
}
