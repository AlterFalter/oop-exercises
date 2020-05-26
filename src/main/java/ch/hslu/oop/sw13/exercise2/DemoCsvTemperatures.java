/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13.exercise2;

import ch.hslu.oop.sw11.exercise2.Temperature;
import ch.hslu.oop.sw13.exercise1.DemoStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class DemoCsvTemperatures {
    private static final Logger LOG = LogManager.getLogger(DemoCsvTemperatures.class);
    
    public static void main(String[] args) {
        String filepath = "C:\\YannisKraemer\\Studium\\OOP\\SW13\\netatmo-export-201801-201804.csv";
        
        List<MeasuringTemperature> measuringTemperatures = loadMeasuringTemeraturesFromCsvFile(filepath);
        
        List<Temperature> temperatures = measuringTemperatures
            .stream()
            .map(mt -> mt.getAsTemperature())
            .collect(Collectors.toList());
        
        LOG.info("measuring temperatures size: " + measuringTemperatures.size());
        LOG.info("temperatures size: " + temperatures.size());
    }
    
    public static List<MeasuringTemperature> loadMeasuringTemeraturesFromCsvFile(String filepath) {
        if (new File(filepath).exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(filepath), Charset.forName("UTF-8")))) {
                
                LOG.info("opened file successfully");
                List<MeasuringTemperature> measuringTemperatures = new ArrayList<MeasuringTemperature>();
                
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] values = line.split(";");
                    
                    int id = Integer.parseInt(values[0]);
                    String unconvertedTimestamp = values[1];
                    float temperatureInCelsius = Float.parseFloat(values[2]);
                    int humidityInPercent = Integer.parseInt(values[3]);
                    
                    measuringTemperatures.add(new MeasuringTemperature(id, temperatureInCelsius, humidityInPercent, unconvertedTimestamp));
                }
                LOG.info("read file successfully");
                return measuringTemperatures;
            }
            catch (IOException ex) {
                LOG.error(ex);
            }
        }
        return null;
    }
}
