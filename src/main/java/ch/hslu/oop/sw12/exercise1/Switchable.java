/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise1;

/**
 * Abstracts an object, which can be switched on and off.
 * @author yannk
 */
public interface Switchable {
    /**
     * Turns the switchable device on.
     */
    void switchOn();
    
    /**
     * Turns the switchable device off.
     */
    void switchOff();
    
    /**
     * Returns whether the switchable device is on.
     * @return Returns a Boolean about if the switchable device is on
     */
    boolean isSwitchedOn();
    
    /**
     * Returns whether the switchable device is off.
     * @return 
     */
    boolean isSwitchedOff();
}
