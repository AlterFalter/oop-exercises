/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 
 * @author Student
 */
public class KopiererLagerTest {
    @Test
    public void testGetAnzahlG1() {
        KopiererLager lager = new KopiererLager();
        assertEquals(2, lager.getAnzahlG1());
    }
    @Test
    public void testGetAnzahlG2() {
        KopiererLager lager = new KopiererLager();
        assertEquals(1, lager.getAnzahlG2());
    }
    @Test
    public void testGetAnzahlG3() {
        KopiererLager lager = new KopiererLager();
        assertEquals(0, lager.getAnzahlG3());
    }
}
