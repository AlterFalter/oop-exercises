/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk12.exercise1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author yannk
 */
public class Car implements Switchable, PropertyChangeListener {
    private static final Logger LOG = LogManager.getLogger(Car.class);
    private Motor motor;
    
    public Car() {
        this.motor = new Motor();
        // old school version:
        //this.motor.subscribeToChange(this);
        // new school (advantage of separating handlers to multiple methods):
        this.motor.addMotorChangeListener(e -> handleMotorStatusChange(e));
    }
    
    @Override
    public void switchOn() {
        this.motor.switchOn();
    }

    @Override
    public void switchOff() {
        this.motor.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return this.isSwitchedOn();
    }

    @Override
    public boolean isSwitchedOff() {
        return this.isSwitchedOff();
    }

    @Override
    public void propertyChange(PropertyChangeEvent arg0) {
        // lands in this method if both of them are 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void handleMotorStatusChange(PropertyChangeEvent event) {
        System.out.println("The motor event handler was called");
        LOG.info("Motor status changed from: " + event.getOldValue() + " | to: " + event.getNewValue());
    }
}
