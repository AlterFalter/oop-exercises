/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise1;

/**
 *
 * @author yannk
 */
public class Light implements Switchable {
    private boolean shines;
    
    public Light() {
        this.shines = false;
    }
    
    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.shines = true;
            // fire event
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.shines = false;
            // TODO: fire event
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.shines;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.isSwitchedOn();
    }
    
}
