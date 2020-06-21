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
public class CrossPrinter {
    public void print(int width, int height) {
        printVerticalStripe(width, height/3);
        printHorizontalStripe(width, (int)Math.ceil(height/3d));
        printVerticalStripe(width, height/3);
    }
    
    public void printVerticalStripe(int width, int height) {
        for (int i = 0; i < height; i++) {
            printVerticalStripe(width);
        }
    }
    
    public void printVerticalStripe(int width) {
        String line = "";
        for (int i = 0; i < width; i++) {
            if (i < width / 3 || i > width / 3 * 2) {
                line += ' ';
            }
            else {
                line += '#';
            }
        }
        System.out.println(line);
    }
    
    public void printHorizontalStripe(int width, int height) {
        for (int i = 0; i < height; i++) {
            printHorizontalStripe(width);
        }
    }
    
    public void printHorizontalStripe(int width) {
        String line = "";
        for (int i = 0; i < width; i++) {
            line += '#';
        }
        System.out.println(line);
    }
}
