/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw03.exercise1;

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
    
    public int getQuadrant() {
        // from point 0,0
        if (x > 0) {
            if (y > 0) {
                // top right
                return 0;
            }
            else {
                // bottom right
                return 1;
            }
        }
        else {
            if (y > 0) {
                // top left
                return 4;
            }
            else {
                // bottom left
                return 3;
            }
        }
    }
    
    public int getQuadrant2() {
        if (x > 0 && y > 0) {
            // top right
            return 0;
        }
        else if (x > 0 && y <= 0) {
            // bottom right
            return 1;
        }
        else if (x <= 0 && y > 0) {
            return 4;
        }
        else {
            return 3;
        }
    }
}
