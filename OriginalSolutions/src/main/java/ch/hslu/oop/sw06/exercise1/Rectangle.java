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
public final class Rectangle extends Shape {
    private int width;
    private int height;
    
    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.changeDimension(width, height);
    }
    
    public void changeDimension(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    @Override
    public int getPerimeter() {
        return 2 * (this.getWidth() + this.getHeight());
    }
    
    @Override
    public int getArea() {
        return this.getWidth() * this.getHeight();
    }
}
