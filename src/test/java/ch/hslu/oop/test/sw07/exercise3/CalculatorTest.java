/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.test.sw07.exercise3;

import ch.hslu.oop.sw07.exercise3.Calculator;
import ch.hslu.oop.sw07.exercise3.CalculatorInterface;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author yannk
 */
public class CalculatorTest {
    private CalculatorInterface calculator;
    
    @BeforeEach
    public void PrepareNewCalculator() {
        this.calculator = new Calculator();
    }
    
    @Test
    public void testAdditionPositiveNumbers() {
        assertEquals(this.calculator.addition(1, 3, 5), 9);
    }
    
    @Test
    public void testAdditionNegativeNumbers() {
        assertEquals(this.calculator.addition(-1, -5, -8), -14);
    }
    
    @Test
    public void testAdditionMixedNumbers() {
        assertEquals(this.calculator.addition(-3, 4, -6, 2), -3);
    }
    
    @Test
    public void testAdditionZero() {
        assertEquals(this.calculator.addition(-3, 0, 2), -1);
    }
    
    @Test
    public void testAdditionIntMax() {
        assertEquals(this.calculator.addition(Integer.MAX_VALUE, -3), 2147483644);
    }
    
    @Test
    public void testAdditionIntPositiveOverflow() {
        assertThrows(Exception.class, () -> this.calculator.addition(Integer.MAX_VALUE, 1));
    }
}
