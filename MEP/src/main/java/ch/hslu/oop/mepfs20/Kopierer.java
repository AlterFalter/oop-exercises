/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import java.util.Objects;

/**
 *
 * @author Student
 */
public abstract class Kopierer implements Comparable<Kopierer> {
    private static int seriennummerZaehler = 60000;
    private final String seriennummer;
    private Druckwerk druckwerk;
    private Toner toner;
    private Generation generation;
    
    public Kopierer(Druckwerk druckwerk, Toner toner, Generation generation) {
        this.seriennummer = "SN" + seriennummerZaehler++;
        this.druckwerk = druckwerk;
        this.toner = toner;
        this.generation = generation;
        if (!toner.isCompatibleTo(generation)) {
            throw new IllegalArgumentException("Toner isn't compatible with generation!");
        }
    }
    
    public String getSeriennummer() {
        return this.seriennummer;
    }
    
    public Druckwerk getDruckwerk() {
        return this.druckwerk;
    }
    
    public Generation getGeneration() {
        return this.generation;
    }
    
    @Override
    public String toString() {
        return "Kopierer[seriennummer=" + this.seriennummer + "; generation=" + this.generation + "; druckwerk=" + this.druckwerk.toString() + "; toner=" + this.toner.toString() + "]";
    }
    
    @Override
    public final boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        else if (!(other instanceof Kopierer)) {
            return false;
        }
        else {
            return this.seriennummer != null && this.seriennummer.equals(((Kopierer)other).seriennummer);
        }
    }
    
    @Override
    public int compareTo(Kopierer other) {
        return this.seriennummer.compareTo(other.seriennummer);
    }
    
    @Override
    public final int hashCode() {
        return Objects.hash(this.seriennummer);
    }
}
