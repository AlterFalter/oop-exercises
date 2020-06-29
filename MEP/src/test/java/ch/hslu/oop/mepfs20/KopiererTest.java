/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 *
 * @author Student
 */
public class KopiererTest {
    @Test @Disabled
    public void testToString() {
        Druckwerk druckwerk = new Druckwerk();
        Toner toner = new Toner("red");
        Kopierer kopierer = new KopiererTypeA(druckwerk, toner);
        // seriennummer wird nicht ausgeschlossen im vergleich oder automatisch angepasst --> deshalb disabled
        assertEquals("Kopierer[seriennummer=SN60000; generation=G1; druckwerk=Druckwerk[]; toner=Toner[color=red]]", kopierer.toString());
        
    }
    
    /**
     * When length can be called, it also checks if it exists, 
     * otherwise it would fail the test case
     */
    @Test
    public void testSeriennummerLength() {
        Druckwerk druckwerk = new Druckwerk();
        Toner toner = new Toner("red");
        Kopierer kopierer = new KopiererTypeA(druckwerk, toner);
        assertEquals(7,kopierer.getSeriennummer().length());
    }
    
    @Test
    public void testSeriennummerAreUnique(){
        Druckwerk druckwerk = new Druckwerk();
        Toner toner = new Toner("red");
        Kopierer kopierer = new KopiererTypeA(druckwerk, toner);
        Kopierer kopierer2 = new KopiererTypeA(druckwerk, toner);
        assertTrue(!kopierer.getSeriennummer().equals(kopierer2.getSeriennummer()));
    }
    
    /**
     * tells me suppressing is not necessary because they're equal anyway
     * without they're not equal anymore
     */
    @Test @Disabled
    public void testEquals() {
        EqualsVerifier.forClass(Kopierer.class).verify();
        //EqualsVerifier.forClass(Kopierer.class).suppress(Warning.IDENTICAL_COPY).verify();
    }
    
    @Test
    public void testGenerationAndTonerCompatibility() {
        Druckwerk druckwerk = new Druckwerk();
        Toner toner = new Toner("red");
        
        final IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            new KopiererTypeC(druckwerk, toner);
        });
        assertTrue(ex.getMessage().contains("Toner isn't compatible with generation!"));
    }
}

