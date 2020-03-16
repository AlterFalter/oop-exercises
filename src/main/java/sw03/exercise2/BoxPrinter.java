/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw03.exercise2;

/**
 *
 * @author yannk
 */
public class BoxPrinter {
    public void print(int width, int height) {
        printHorizontalLine(width);
        if (height > 1) {
            for (int i = 0; i < height-2; i++) {
                printHorizontalLine(width);
            }
            printHorizontalLine(width);
        }
    }
    
    public void printHorizontalLine(int width) {
        String line = "";
        for (int i = 0; i < 10; i++) {
            line += '#';
        }
        System.out.println(line);
    }
    
    public void printVerticalLine(int width) {
        String line = "";
        for (int i = 0; i < width; i++) {
            if (i == 0 || i == width - 1) {
                line += '#';
            }
            else {
                line += ' ';
            }
        }
        System.out.println(line);
    }
}
