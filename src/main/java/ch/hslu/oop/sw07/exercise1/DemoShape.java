/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07.exercise1;

import ch.hslu.oop.sw06.exercise1.Shape;
import ch.hslu.oop.sw06.exercise1.Circle;

/**
 *
 * @author yannk
 */
public class DemoShape {
    public static void main(String[] arg) {
        // WTF WHY????
        // can't call anything on shape1
        Shape shape1 = new Circle(1,1,1);
        shape1.getX();
    }
}
