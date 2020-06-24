/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk07.exercise1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Student
 */
public class Point {
    private static final Logger LOG = LogManager.getLogger(Point.class);
    
    private int x;
    private int y;
    
    /**
     * Initializes Point on zero coordinates
     */
    public Point() {
        this(0, 0);
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * copy constructor
     * @param point that is copied
     */
    public Point(Point point) {
        this(point.getX(), point.getY());
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void moveRelative(int xDelta, int yDelta) {
        if ((long)this.getX() + xDelta > Integer.MAX_VALUE) {
            throw new ArithmeticException("X delta causes an overflow");
        }
        else if ((long)this.getX() + xDelta < Integer.MIN_VALUE) {
            throw new ArithmeticException("X delta causes a negative overflow");
        }
        else if ((long)this.getY() + yDelta > Integer.MAX_VALUE) {
            throw new ArithmeticException("Y delta causes an overflow");
        }
        else if ((long)this.getY() + yDelta < Integer.MIN_VALUE) {
            throw new ArithmeticException("Y delta causes a negative overflow");
        }
        else {
            this.setX(this.getX() + xDelta);
            this.setY(this.getY() + yDelta);
        }
    }
    
    public void moveRelative(Point vector) {
        this.moveRelative(vector.getX(), vector.getY());
    }
    
    /**
     * use polar coordinates
     * @param angle
     * @param radius 
     */
    public void moveRelative(float angle, float radius) {
        // Math lib wants radian
        angle = (float)Math.toRadians(angle);
        int xDelta = (int)Math.round(Math.cos(angle) * radius);
        int yDelta = (int)Math.round(Math.sin(angle) * radius);
        this.moveRelative(xDelta, yDelta);
    }
}