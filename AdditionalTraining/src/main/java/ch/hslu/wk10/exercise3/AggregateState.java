/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk10.exercise3;

/**
 *
 * @author Student
 */
public enum AggregateState {
    SOLID("fest"),
    FLUID("flüssig"),
    GAS("gasförmig");
    
    private String germanTranslation;
    
    private AggregateState(String germanTranslation) {
        this.germanTranslation = germanTranslation;
    }
    
    public String getGermanTranslation() {
        return this.germanTranslation;
    }
}
