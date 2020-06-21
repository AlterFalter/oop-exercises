/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk13.exercise2;

import ch.hslu.wk12.exercise1.Car;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class TemperatureHistory {
    private static final Logger LOG = LogManager.getLogger(TemperatureHistory.class);
    private List<Temperature> temperatures;
    
    public TemperatureHistory() {
        this.temperatures = new ArrayList<>();
    }
    
    public void addTemperature(Temperature temperature) {
        this.temperatures.add(temperature);
    }
    
    public float getAverageTemperatureInKelvin() {
        if (!this.temperatures.isEmpty()) {
            OptionalDouble result = this.temperatures
                .stream()
                .mapToDouble(t -> t.getTemperatureInKelvin())
                .average();
            return (float)result.getAsDouble();
        }
        throw new IndexOutOfBoundsException("no temperatures yet in " + TemperatureHistory.class.getSimpleName());
    }
                
    public float getMinTemperatureInKelvin() {
        if (!this.temperatures.isEmpty()) {
            return (float)this.temperatures
                    .stream()
                    .mapToDouble(t -> t.getTemperatureInKelvin())
                    .min()
                    .getAsDouble();
        }
        throw new IndexOutOfBoundsException("no temperatures yet in " + TemperatureHistory.class.getSimpleName());
    }
                
    public Temperature getMinTemperature() {
        if (!this.temperatures.isEmpty()) {
            return Collections.min(this.temperatures);
        }
        throw new IndexOutOfBoundsException("no temperatures yet in " + TemperatureHistory.class.getSimpleName());
    }
    
    public Temperature getMaxTemperature() {
        if (!this.temperatures.isEmpty()) {
            return Collections.max(this.temperatures);
        }
        throw new IndexOutOfBoundsException("No temperatures yet in " + TemperatureHistory.class.getSimpleName());
    }
    
    public float getMaxTemperatureInKelvin() {
        if (!this.temperatures.isEmpty()) {
            return (float)this.temperatures
                    .stream()
                    .mapToDouble(t -> t.getTemperatureInKelvin())
                    .max()
                    .getAsDouble();
        }
        throw new IndexOutOfBoundsException("No temperatures yet in " + TemperatureHistory.class.getSimpleName());
    }
    
    public boolean save(String filepath) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), Charset.forName("UTF-8"))))) {
            for (Temperature temperature : this.temperatures) {
                pw.write(Float.toString(temperature.getTemperatureInKelvin()) + "\n");
            }
            
            pw.flush();
            return true;
        }
        catch (FileNotFoundException ex) {
            LOG.error(ex.getMessage(), ex);
            return false;
        }
    }
    
    public static TemperatureHistory load(String path) {
        // based on: IO Datenströme Folie 28
        if (new File(path).exists()) {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("UTF-8")))) {
                String line;
                TemperatureHistory history = new TemperatureHistory();
                while ((line = reader.readLine()) != null) {
                    LOG.debug("read line: " + line);
                    float temperatureInKelvin = Float.parseFloat(line);
                    LOG.debug("successfully parsed String to float: " + temperatureInKelvin);
                    history.addTemperature(new Temperature(temperatureInKelvin));
                }
                LOG.info("Loaded file successfully");
                return history;
            }
            catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        String text = "TemperatureHistory | Length: " + this.temperatures.size() + " | ";
        text += this.temperatures.stream().map(t -> t.toString()).collect(Collectors.joining(", "));
        return text;
    }
}
