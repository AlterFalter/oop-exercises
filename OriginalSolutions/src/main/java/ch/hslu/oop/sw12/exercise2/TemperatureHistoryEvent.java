/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise2;

import java.util.EventObject;

/**
 *
 * @author yannk
 */
public class TemperatureHistoryEvent extends EventObject {
    // TODO: change to Temperature
    private final float newValue;
    
    public TemperatureHistoryEvent(Object source, float newValue) {
        super(source);
        this.newValue = newValue;
    }
    
    public float getNewValue() {
        return this.newValue;
    }
}
