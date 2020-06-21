/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw03.exercise1;

import ch.hslu.oop.sw03.exercise1.MathHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author yannk
 */
public class MathHelperTest {
    @Test
    public void testMaxPositiveNumbers() {
        assertEquals(MathHelper.max(1, 4), 4);
    }
    
    @Test
    public void testMaxNegativeNumbers() {
        assertEquals(MathHelper.max(-1, -7), -1);
    }
    
    @Test
    public void testMaxZero() {
        assertEquals(MathHelper.max(0, 1), 1);
    }
    
    @Test
    public void testMaxSameNumber() {
        assertEquals(MathHelper.max(6, 6), 6);
    }
}
