/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw10.exercise3;

import ch.hslu.oop.sw10.exercise3.Element;
import ch.hslu.oop.sw10.exercise3.AggregatePhase;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author yannk
 */
public class ElementTest {
    @Test
    public void testGetName() {
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        assertEquals("Stickstoff", element.getName());
    }
    
    @Test
    public void testGetNameWhenEmpty() {
        Element element = new Element("", "N", -210.1f, -196f);
        assertEquals("", element.getName());
    }
    
    @Test
    public void testGetAbbreviation() {
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        assertEquals("N", element.getAbbreviation());
    }
    
    @Test
    public void testGetAbbreviationWhenEmpty() {
        Element element = new Element("Stickstoff", "", -210.1f, -196f);
        assertEquals("", element.getAbbreviation());
    }
    
    @Test
    public void testGetAggregatePhaseWhenSolid() {
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        assertEquals(AggregatePhase.SOLID, element.getAggregatePhase(-300f));
    }
    
    @Test
    public void testGetAggregatePhaseWhenLiquid(){
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        assertEquals(AggregatePhase.LIQUID, element.getAggregatePhase(-197f));
    }
    
    
    @Test
    public void testGetAggregatePhaseWhenGas(){
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        assertEquals(AggregatePhase.GAS, element.getAggregatePhase(0f));
    }
    
    @Test
    public void testPrintAggregatePhase() {
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        final String output = "Stickstoff is in the GAS state with the temperature: 32.0 °C";
        assertEquals(output, element.printAggregatePhase(32f));
    }
    
    @Test
    public void testPrintAggregatePhaseInGerman() {
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        final String output = "Stickstoff ist bei -220.0°C fest";
        assertEquals(output, element.printAggregatePhaseInGerman(-220f));
    }
    
    @Test
    public void testToString() {
        Element element = new Element("Stickstoff", "N", -210.1f, -196f);
        final String output = "Class: Element - Name: Stickstoff | Abbreviation: N | melting point: -210.1°C | boiling point: -196.0°C";
        assertEquals(output, element.toString());
    }
    
    @Test
    public void testEqualsVerifier() {
        EqualsVerifier.forClass(Element.class).verify();
    }
    
    @Test
    public void testHashCodeConsistency() {
        Element element = Element.getElements()[2];
        assertEquals(element.hashCode(), element.hashCode());
    }
    
    @Test
    public void testHashCodeAreUnique() {
        int hashCode1 = Element.getElements()[0].hashCode();
        int hashCode2 = Element.getElements()[1].hashCode();
        assertFalse(hashCode1 == hashCode2);
    }
}
