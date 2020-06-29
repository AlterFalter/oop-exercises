/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Student
 */
public class GenerationTest {
    @Test
    public void testGeneration1() {
        assertEquals(2012, Generation.G1.getYear());
    }
    @Test
    public void testGeneration2() {
        assertEquals(2014, Generation.G2.getYear());
    }
    @Test
    public void testGeneration3() {
        assertEquals(2017, Generation.G3.getYear());
    }
}
