/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk12.exercise2;

import ch.hslu.wk13.exercise2.Temperature;
import java.util.EventObject;

/**
 *
 * @author Student
 */
public class TemperatureMaxChangeEvent extends EventObject {
    private Temperature newValue;
    
    public TemperatureMaxChangeEvent(Object source, Temperature newValue) {
        super(source);
        this.newValue = newValue;
    }
    
    public Temperature getNewValue() {
        return this.newValue;
    }
}
