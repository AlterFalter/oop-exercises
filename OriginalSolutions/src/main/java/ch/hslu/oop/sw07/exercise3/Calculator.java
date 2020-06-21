/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07.exercise3;

import java.util.stream.IntStream;

/**
 *
 * @author yannk
 */
public class Calculator implements CalculatorInterface {
    public int addition(int... numbers) {
        return IntStream.of(numbers).sum();
    }
}
