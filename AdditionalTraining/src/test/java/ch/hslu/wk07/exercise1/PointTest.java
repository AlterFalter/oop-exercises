/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk07.exercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Student
 */
public class PointTest {
    @Test
    public void testConstructorAndGetters() {
        Point point = new Point(55, 34);
        assertEquals(55, point.getX());
        assertEquals(34, point.getY());
    }
    
    @Test
    public void testDefaultConstructor() {
        Point point = new Point();
        assertEquals(0, point.getX());
        assertEquals(0, point.getY());
    }
    
    @Test
    public void testCopyConstructor() {
        Point originalPoint = new Point(42, 68); 
        Point copiedPoint = new Point(originalPoint);
        assertEquals(42, copiedPoint.getX());
        assertEquals(68, copiedPoint.getY());
    }
    
    @Test
    public void testSetX() {
        Point point = new Point(15, 29);
        point.setX(25);
        assertEquals(25, point.getX());
    }
    
    @Test
    public void testSetY() {
        Point point = new Point(15, 29);
        point.setY(87);
        assertEquals(87, point.getY());
    }
    
    @Test
    public void testMoveRelativeWithPositiveNumbers() {
        Point point = new Point(45, 99);
        point.moveRelative(5, 51);
        assertEquals(50, point.getX());
        assertEquals(150, point.getY());
    }
    
    @Test
    public void testMoveRelativeWithNegativeNumbers() {
        Point point = new Point(45, 99);
        point.moveRelative(-15, -161);
        assertEquals(30, point.getX());
        assertEquals(-62, point.getY());
    }
    
    @Test
    public void testMoveRelativeXOverflow() {
        Point point = new Point(10, 48);
        final ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
            point.moveRelative(Integer.MAX_VALUE ,45463);
        });
        assertTrue(ex.getMessage().contains("X delta causes an overflow"));
    }
    
    @Test
    public void testMoveRelativeXNegativeOverflow() {
        Point point = new Point(-145, 48);
        final ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
            point.moveRelative(Integer.MIN_VALUE ,-48925);
        });
        assertTrue(ex.getMessage().contains("X delta causes a negative overflow"));
    }
    
    @Test
    public void testMoveRelativeYOverflow() {
        Point point = new Point(10, 48);
        final ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
            point.moveRelative(3565683,Integer.MAX_VALUE);
        });
        assertTrue(ex.getMessage().contains("Y delta causes an overflow"));
    }
    
    @Test
    public void testMoveRelativeYNegativeOverflow() {
        Point point = new Point(-145, -48);
        final ArithmeticException ex = assertThrows(ArithmeticException.class, () -> {
            point.moveRelative(-48925, Integer.MIN_VALUE);
        });
        assertTrue(ex.getMessage().contains("Y delta causes a negative overflow"));
    }
    
    @Test
    public void testMoveRelativeWithVector() {
        Point vector = new Point(-176, 637);
        Point point = new Point(45, 99);
        point.moveRelative(vector);
        assertEquals(-131, point.getX());
        assertEquals(736, point.getY());
    }
    
    @Test
    public void testMoveRelativeWithPolarCoordinates() {
        Point point = new Point();
        point.moveRelative(22.6f, 13f);
        assertEquals(12, point.getX());
        assertEquals(5, point.getY());
    }
}
