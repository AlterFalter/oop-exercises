/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author yannk
 */
public class Car implements Switchable, PropertyChangeListener {
    private Motor motor;
    private Light frontLeftLight;
    private Light frontRightLight;
            
    public Car() {
        this.motor = new Motor();
        this.frontLeftLight = new Light();
        this.frontRightLight = new Light();
        
        this.motor.addMotorStateChangeListener(this);
        //this.frontLeftLight.
    }

    @Override
    public void switchOn() {
        this.motor.switchOn();
        this.frontLeftLight.switchOn();
        this.frontRightLight.switchOn();
    }

    @Override
    public void switchOff() {
        this.motor.switchOff();
        this.frontLeftLight.switchOff();
        this.frontRightLight.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return this.motor.isSwitchedOn();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn();
    }
    
    //public void hand

    @Override
    public void propertyChange(PropertyChangeEvent propertyChanged) {
        switch (propertyChanged.getPropertyName()) {
            case "motorState":
                System.out.println("Motor status changed from " + propertyChanged.getOldValue() + " to " + propertyChanged.getNewValue());
                break;
            case "light":
            default:
                System.out.println("unknown property changed: " + propertyChanged.getPropertyName());
        }
    }
}
