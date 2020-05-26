/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13.exercise1;

import ch.hslu.oop.sw11.exercise3.DemoNumberInputWithLogger;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yannk
 */
public class DemoStream {
    private static final Logger LOG = LogManager.getLogger(DemoStream.class);
    
    public static void main(String[] args) {
        // backslash in windows!
        String filepath = "C:\\YannisKraemer\\Studium\\Temp\\sw13exercise1a.txt";
        
        writeAndReadNumberFromFile(filepath, 4);
        writeAndReadNumberFromFile(filepath, 0);
        writeAndReadNumberFromFile(filepath, Integer.MAX_VALUE);
        writeAndReadNumberFromFile(filepath, Integer.MIN_VALUE);
    }
    
    private static void writeAndReadNumberFromFile(String filepath, int numberToSave) {
        writeNumberToFile(filepath, numberToSave);
        
        try {
            int readNumber = readNumberFromFile(filepath, "int");
            readNumber = readNumberFromFile(filepath, "byte");
            readNumber = readNumberFromFile(filepath, "float");
        }
        catch (IOException ex) {
            LOG.error("you fucked up");
        }
    }
    
    private static void writeNumberToFile(String filepath, int numberToSave) {
//        try (PrintWriter pw = new PrintWriter(
//                                new BufferedWriter(
//                                    new OutputStreamWriter(
//                                        new FileOutputStream(filepath), Charset.forName("UTF-8"))))) {
//            pw.println(numberToSave);
//        }
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filepath))) {
            dataOutputStream.writeInt(numberToSave);
            LOG.info("written number " + numberToSave + " successfully to file " + filepath);
        }
        catch (IOException ex) {
            LOG.error(ex);
        }
    }
    
    private static int readNumberFromFile(String filepath, String datatype) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filepath))) {
            if (datatype == "int") {
                int number = dataInputStream.readInt();
                LOG.info("read as int: " + number);
                return number;
            }
            else if (datatype == "float") {
                float number = dataInputStream.readFloat();
                LOG.info("read as float: " + number);
                return Math.round(number);
            }
            else {
                Byte number = dataInputStream.readByte();
                LOG.info("read as byte: " + number);
                return number;
            }
        }
        catch (IOException ex) {
            LOG.error(ex);
            throw ex;
        }
    }
}
