/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk12.exercise2;

import ch.hslu.wk13.exercise2.Temperature;
import java.util.ArrayList;
import java.util.List;

/**
 * This class "upgrades" the class from wk13.exercise2
 * It adds events for new min and max
 * @author Student
 */
public class TemperatureHistory extends ch.hslu.wk13.exercise2.TemperatureHistory {
    private final List<TemperatureHistoryNewMaxListener> newMaxListeners;
    
    public TemperatureHistory() {
        this.newMaxListeners = new ArrayList<>();
    }
    
    @Override
    public void addTemperature(Temperature temperature) {
        Temperature currentMaxTemperature = null;
        if (this.hasTemperatures()) {
            currentMaxTemperature = this.getMaxTemperature();
        }
        
        super.addTemperature(temperature);
        
        if (this.size() == 1 || (currentMaxTemperature != null && currentMaxTemperature.compareTo(this.getMaxTemperature()) == -1)) {
            LOG.info("found new max in TemperatureHistory");
            TemperatureMaxChangeEvent event = new TemperatureMaxChangeEvent(this, temperature);
            this.fireNewMaxEvent(event);
        }
    }
    
    public void addNewMaxListener(TemperatureHistoryNewMaxListener newListener) {
        this.newMaxListeners.add(newListener);
    }
    
    public void fireNewMaxEvent(TemperatureMaxChangeEvent event) {
        for (TemperatureHistoryNewMaxListener newMaxListener : this.newMaxListeners) {
            newMaxListener.notifyOnNewMaxInTemperatureHistory(event);
        }
    }
}
