/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw04.exercise2;

/**
 *
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
     * Returns if the switchable device is on.
     * @return Returns a boolean about if the switchable device is on
     */
    boolean isSwitchedOn();
    
    /**
     * Returns if the switchable device is off.
     * @return 
     */
    boolean isSwitchedOff();
}
