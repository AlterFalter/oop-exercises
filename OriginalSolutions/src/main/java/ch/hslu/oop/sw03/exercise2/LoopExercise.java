/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw03.exercise2;

/**
 *
 * @author yannk
 */
public class LoopExercise {
    public void printNumbers() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    
    public void floatCalculation() {
        float number = 0.9f;
        int numberOfLoops = 0;
        while (number < 1) {
            number += 0.000025f;
            numberOfLoops++;
        }
        System.out.println(number);
        System.out.println("Number of loops: " + numberOfLoops);
    }
    
    public void floatCalculation2() {
        float startingPoint = 0.9f;
        int numberOfLoops = 0;
        do {
            numberOfLoops++;
        } while (0.000025f * numberOfLoops + 0.9f < 1);
        System.out.println("Number of loops: " + numberOfLoops);
    }
}
