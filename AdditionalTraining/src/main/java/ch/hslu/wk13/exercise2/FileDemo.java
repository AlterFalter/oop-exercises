/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk13.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class FileDemo {
    private static final Logger LOG = LogManager.getLogger(FileDemo.class);
    public static void main(String[] args) {
        TemperatureHistory history = new TemperatureHistory();
        history.addTemperature(new Temperature(4.55f));
        history.addTemperature(new Temperature(55f));
        history.addTemperature(new Temperature(350f));
        history.addTemperature(new Temperature(77.25f));
        final String filepath = "C:/temp/OOPExercises2_temperature.txt";
        history.save(filepath);
        
        TemperatureHistory history2 = TemperatureHistory.load(filepath);
        if (history2 != null) {
            System.out.println(history2.toString());
        }
        else {
            LOG.error("Couldn't load file under filepath: " + filepath);
        }
    }
}
