/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13.exercise1;

import ch.hslu.oop.sw11.exercise2.Temperature;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class DemoSaveTemperature {
    private static final Logger LOG = LogManager.getLogger(DemoStream.class);
    
    public static void main(String[] args) {
        String filepath = "C:\\YannisKraemer\\Studium\\Temp\\sw13exercise1c.txt";
        
        List<Temperature> temperatures = new ArrayList<Temperature>();
        temperatures.add(Temperature.createFromCelsius(4.34f));
        temperatures.add(Temperature.createFromCelsius(7.9f));
        temperatures.add(Temperature.createFromCelsius(240f));
        
        if (saveTemperatures(temperatures, filepath)) {
            LOG.info("saved temperatures successfully");
            List<Temperature> loadedTemperatures = loadTemperatures(filepath);
            if (loadedTemperatures != null) {
                LOG.info("loaded temperatures successfully");
            }
        }
        
    }
    
    public static boolean saveTemperatures(List<Temperature> temperatures, String filepath) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filepath))) {
            dataOutputStream.writeInt(temperatures.size());
            temperatures.stream().forEach(t -> {
                try {
                    dataOutputStream.writeFloat(t.getTemperatureInKelvin());
                } catch (IOException ex) {
                    LOG.error(ex);
                }
            });
            LOG.info("written successfully to file " + filepath);
            return true;
        }
        catch (IOException ex) {
            LOG.error(ex);
            return false;
        }
    }
    
    public static List<Temperature> loadTemperatures(String filepath) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filepath))) {
            int numberOfTemperatures = dataInputStream.readInt();
            LOG.info("number of temperatures in file: " + numberOfTemperatures);
            List<Temperature> temperatures = new ArrayList<Temperature>();
            for (int i = 0; i < numberOfTemperatures; i++) {
                temperatures.add(Temperature.createFromKelvin(dataInputStream.readFloat()));
                LOG.info("loaded temperature: " + temperatures.get(temperatures.size() -1).getTemperatureInCelsius() + "°C");
            }
            LOG.info("finished reading from file");
            return temperatures;
        }
        catch (IOException ex) {
            LOG.error(ex);
            return null;
        }
    }
}
