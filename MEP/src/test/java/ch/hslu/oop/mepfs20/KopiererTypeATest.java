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
public class KopiererTypeATest {
    @Test
    public void testGeneration() {
        Druckwerk druckwerk = new Druckwerk();
        Toner toner = new Toner("red");
        Kopierer kopierer = new KopiererTypeA(druckwerk, toner);
        assertEquals(Generation.G1, kopierer.getGeneration());
    }
}
