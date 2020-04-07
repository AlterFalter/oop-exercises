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
public class Circle extends Shape {
    private int diameter;
    
    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.setDiameter(diameter);
    }
    
    public final void setDiameter(int newDiameter) {
        this.diameter = newDiameter;
    }
    
    public int getDiameter() {
        return this.diameter;
    }
    
    @Override
    public int getPerimeter() {
        return (int)(2 * this.getDiameter() * Math.PI);
    }
    
    @Override
    public int getArea() {
        return (int)(Math.pow(this.getDiameter(), 2) * Math.PI);
    }
}
