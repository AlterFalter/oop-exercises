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
public class DemoShape {
    public static void main(String[] arg) {
        Shape rectangle = new Rectangle(2, 3, 6, 4);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
        // space nicht vergessen
        ((Rectangle) rectangle).getHeight();
        
        Shape circle = new Circle(8, 6, 3);
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
    }
}
