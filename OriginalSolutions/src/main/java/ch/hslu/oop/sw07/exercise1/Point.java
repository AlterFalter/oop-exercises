/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07.exercise1;

/**
 *
 * @author yannk
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    public int getX() {
        return this.x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int newY) {
        this.y = newY;
    }
    
    public void moveRelative(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
    
    public void moveRelative(Point newRelativeCoordinates) {
        this.moveRelative(newRelativeCoordinates.getX(), newRelativeCoordinates.getY());
    }
    
    /**
     * polar coordinates
     */
    public void moveRelative(float degree, float radius) {
        int x = (int)Math.round(Math.cos(degree) * radius);
        int y = (int)Math.round(Math.sin(degree) * radius);
        
        this.moveRelative(x, y);
    }
}
