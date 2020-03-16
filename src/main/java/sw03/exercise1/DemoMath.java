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
public class DemoMath {
    public int max(final int a, final int b) {
        if (a > b) {
            return a;
        }
        else {
            return b;
        }
    }
    
    public int max2(final int a, final int b) {
        return (a > b)? a : b;
    }
    
    public int max3(final int a, final int b) {
        return Math.max(a, b);
    }
    
    public int max(final int a, final int b, final int c) {
        if (a >= b && a >= c) {
            return a;
        }
        // a can't be the biggest --> no need to check for a
        else if (b >= c) {
            return b;
        }
        else {
            return c;
        }
    }
    
    public int max2(final int a, final int b, final int c) {
        int maxNumber = this.max(a, b);
        maxNumber = this.max(maxNumber, c);
        return maxNumber;
    }
    
    public int max(final int... numbers) {
        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }
        return maxNumber;
    }
    
    public int max2(final int... numbers) {
        int maxNumber = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            maxNumber = max(maxNumber, numbers[i]);
        }
        return maxNumber;
    }
}
