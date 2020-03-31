/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw04.exercise2;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yannk
 */
public class Motor implements Switchable, Runnable {
    public final int ACCELERATION = 10;
    public final int MAX_RPM = 100;
    
    private Thread thread;
    private String threadName;
    
    private boolean switchState;
    public int rpm;
    
    // Alternative: Parameter mit Thread Name
    public Motor() {
        this.switchState = false;
        this.threadName = UUID.randomUUID().toString();
    }
    
    @Override
    public void switchOn() {
        this.switchState = true;
        if (this.thread == null) {
            this.thread = new Thread(this, this.threadName);
            this.thread.start();
        }
    }
    
    @Override
    public void switchOff() {
        this.switchState = false;
    }
    
    @Override
    public boolean isSwitchedOn() {
        return this.switchState;
    }
    
    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn() && this.rpm == 0;
    }
    
    // override nicht vergessen
    @Override
    public void run() {
        while (this.accelerate()) {
        }
    }
    
    public boolean accelerate() {
        if (isSwitchedOn()) {
            if (this.getRpm() < MAX_RPM) {
                this.setRpm(this.getRpm() + ACCELERATION);
                System.out.println("accelerate");
            }
        }
        else if (this.getRpm() > 0) {
            this.setRpm(this.getRpm() - ACCELERATION);
            System.out.println("deaccelerate");
        }
        else {
            System.out.println("stopped");
            return false;
        }
        
        System.out.println(this.rpm);
        this.sleep(1000);
        return true;
    }
    
    public int getRpm() {
        synchronized (this) {
            return this.rpm;
        }
    }
    
    public void setRpm(int newRpm) {
        synchronized (this) {
            this.rpm = newRpm;
            if (this.rpm < 0) {
                this.rpm = 0;
            }
        }
    }
    
    // ganze Methode synchronized: public synchronized boolean 
    // object attribute zum abfragen
    public boolean getSwitchState() {
        synchronized (this) {
            return this.switchState;
        }
    }
    
    
    public void setSwitchState(boolean newSwitchState) {
        synchronized (this) {
            this.switchState = newSwitchState;
        }
    }
    
    public void sleep(int ms) {
        try {
            this.thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Couldn't sleep :/");
        }
    }
}
