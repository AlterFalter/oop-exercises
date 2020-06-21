/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannk
 */
public class Motor implements Switchable {
    private final List<PropertyChangeListener> motorStatusChangeListeners = new ArrayList<>();
    
    private boolean motorState;
    
    public void addMotorStateChangeListener(final PropertyChangeListener motorStatusChangeListener) {
        this.motorStatusChangeListeners.add(motorStatusChangeListener);
    }
    
    public void removeMotorStateChangeListener(final PropertyChangeListener motorStatusChangeListener) {
        this.motorStatusChangeListeners.remove(motorStatusChangeListener);
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.motorState = true;
            final PropertyChangeEvent motorStateChangeEvent = new PropertyChangeEvent(this, "motorState", false, true);
            this.fireMotorStateChangedEvent(motorStateChangeEvent);
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.motorState = false;
            final PropertyChangeEvent motorStateChangeEvent = new PropertyChangeEvent(this, "motorState", true, false);
            this.fireMotorStateChangedEvent(motorStateChangeEvent);
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.motorState;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn();
    }
    
    public void fireMotorStateChangedEvent(final PropertyChangeEvent properyChangeEvent) {
        for (PropertyChangeListener motorStatusChangeListener : motorStatusChangeListeners) {
            motorStatusChangeListener.propertyChange(properyChangeEvent);
        }
    }
}
