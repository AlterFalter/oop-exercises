/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk12.exercise1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class Motor implements Switchable {
    private static final Logger LOG = LogManager.getLogger(Motor.class);
    private List<PropertyChangeListener> motorChangeListeners;
    private boolean motorStatus;
    
    public Motor() {
        this.motorChangeListeners = new ArrayList<>();
        this.motorStatus = false;
    }
    
    public void addMotorChangeListener(PropertyChangeListener motorChangeListener) {
        if (motorChangeListener != null) {
            LOG.info("New listener registered on Motor");
            motorChangeListeners.add(motorChangeListener);
        }
    }
    
    public void removeMotorChangeListener(PropertyChangeListener motorChangeListener) {
        motorChangeListeners.remove(motorChangeListener);
    }
    
    @Override
    public void switchOn() {
        LOG.info("Someone tries to switch on Motor");
        if (this.isSwitchedOff()) {
            LOG.info("Motor gets switched on");
            this.motorStatus = true;
            PropertyChangeEvent motorChangeEvent = new PropertyChangeEvent(this, "motorStatus", false, true);
            fireMotorChangeEvent(motorChangeEvent);
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.motorStatus = false;
            PropertyChangeEvent motorChangeEvent = new PropertyChangeEvent(this, "motorStatus", true, false);
            fireMotorChangeEvent(motorChangeEvent);
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.motorStatus;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn();
    }
    
    private void fireMotorChangeEvent(final PropertyChangeEvent propertyChangeEvent) {
        for (final PropertyChangeListener listener : this.motorChangeListeners) {
            listener.propertyChange(propertyChangeEvent);
        }
    }
}
