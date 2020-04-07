/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw04.exercise3;

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
}
