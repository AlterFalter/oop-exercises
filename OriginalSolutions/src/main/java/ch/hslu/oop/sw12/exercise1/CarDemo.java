/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw12.exercise1;

/**
 *
 * @author yannk
 */
public class CarDemo {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        car.switchOn();
        Thread.sleep(2500, 0);
        System.out.println("driving to rome...");
        Thread.sleep(2500, 0);
        car.switchOff();
    }
}
