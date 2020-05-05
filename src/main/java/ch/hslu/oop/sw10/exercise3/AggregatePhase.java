/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10.exercise3;

/**
 *
 * @author yannk
 */
public enum AggregatePhase {
    SOLID("fest"),
    LIQUID("flüssig"),
    GAS("gasförmig");
    
    private final String germanTranslation;
    
    private AggregatePhase(final String germanTranslation) {
        this.germanTranslation = germanTranslation;
    }
    
    public String getGermanTranslation() {
        return this.germanTranslation;
    }
}
