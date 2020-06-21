/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw10.exercise3;

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
public class AggregatePhaseTest {
    @Test
    public void testGermanTranslationFromSolid() {
        assertEquals("fest", AggregatePhase.SOLID.getGermanTranslation());
    }
    
    @Test
    public void testGermanTranslationFromLiquid() {
        assertEquals("flüssig", AggregatePhase.LIQUID.getGermanTranslation());
    }
    
    @Test
    public void testGermanTranslationFromGas() {
        assertEquals("gasförmig", AggregatePhase.GAS.getGermanTranslation());
    }
}
