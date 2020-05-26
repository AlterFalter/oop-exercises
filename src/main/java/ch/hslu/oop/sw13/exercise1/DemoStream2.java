/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13.exercise1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class DemoStream2 {
    private static final Logger LOG = LogManager.getLogger(DemoStream.class);
    
    public static void main(String[] args) {
        // backslash in windows!
        String filepath = "C:\\YannisKraemer\\Studium\\Temp\\sw13exercise1b.txt";
        
        writeToFile(filepath);
        try {
            readCorrectlyFromFile(filepath);
            readWronglyFromFile(filepath);
        }
        catch (IOException ex) {
            LOG.error("You fucked up");
        }
    }
    
    
    private static void writeToFile(String filepath) {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filepath))) {
            dataOutputStream.writeInt(15);
            dataOutputStream.writeChars("Just do it");
            dataOutputStream.writeFloat(5.4f);
            LOG.info("written successfully to file " + filepath);
        }
        catch (IOException ex) {
            LOG.error(ex);
        }
    }
    
    private static void readCorrectlyFromFile(String filepath) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filepath))) {
            LOG.info("int: " + dataInputStream.readInt());
            LOG.info("string: " + dataInputStream.readUTF());
            LOG.info("float: " + dataInputStream.readFloat());
        }
        catch (IOException ex) {
            LOG.error(ex);
            throw ex;
        }
    }
    
    private static void readWronglyFromFile(String filepath) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filepath))) {
            LOG.info("float: " + dataInputStream.readFloat());
            LOG.info("int: " + dataInputStream.readInt());
            LOG.info("string: " + dataInputStream.readUTF());
        }
        catch (IOException ex) {
            LOG.error(ex);
            throw ex;
        }
    }
}
