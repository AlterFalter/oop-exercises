/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.wk12.exercise1;

/**
 *
 * @author yannk
 */
public class CarDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.switchOn();
        car.switchOff();
        car.switchOn();
        System.out.println("program ended");
    }
}
