/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13.exercise2;

import ch.hslu.oop.sw11.exercise2.Temperature;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class MeasuringTemperature {
    private static final Logger LOG = LogManager.getLogger(MeasuringTemperature.class);
    
    private int id;
    private float temperatureInCelsius;
    private int humidityInPercent;
    private Timestamp timestamp;
    
    public MeasuringTemperature(int id, float temperatureInCelsius, int humidityInPercent, Timestamp timestamp) {
        this.id = id;
        this.temperatureInCelsius = temperatureInCelsius;
        this.humidityInPercent = humidityInPercent;
        this.timestamp = timestamp;
    }
    
    public MeasuringTemperature(int id, float temperatureInCelsius, int humidityInPercent, String timestampText) {
        this(id, temperatureInCelsius, humidityInPercent, convertStringToTimestamp(timestampText));
    }
    
    public Temperature getAsTemperature() {
        return Temperature.createFromCelsius(temperatureInCelsius);
    }
    
    private static Timestamp convertStringToTimestamp(String unconvertedTimestamp) {
        //LOG.debug("unconvertedTimestamp: " + unconvertedTimestamp);
        return Timestamp.from(LocalDateTime
            .parse(unconvertedTimestamp, 
                DateTimeFormatter
                    .ofPattern("\"yyyy/MM/dd HH:mm:ss\""))
                    .toInstant(ZoneOffset.UTC));
    }
}
