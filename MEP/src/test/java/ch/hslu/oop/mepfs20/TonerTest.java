/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import ch.hslu.oop.mepfs20.Toner;
import org.junit.jupiter.api.Test;
        
/**
 *
 * @author Student
 */
public class TonerTest {
    @Test
    public void testDefaultCosntructor() {
        Toner toner = new Toner();
        assertEquals("black", toner.getColor());
    }
    
    @Test
    public void testConstructorWithColor() {
        Toner toner = new Toner("red");
        assertEquals("red", toner.getColor());
    }
}
