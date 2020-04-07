/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw06.exercise1;

/**
 *
 * @author yannk
 */
public abstract class Shape {
    private int x;
    private int y;
    
    protected Shape(int x, int y) {
        // überschreibbare Methode in Konstruktor gefährlich
        // deshalb "final" nützen
        this.move(x, y);
    }
    
    public final void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    // abstrakte Methoden dokumentieren
    public abstract int getPerimeter();
    
    public abstract int getArea();
}
