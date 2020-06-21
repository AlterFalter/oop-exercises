/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw01.exercise3;

import java.awt.Color;

/**
 *
 * @author Yannis Kraemer
 */
public class Program {
    public static void main(String[] arg) {
        Person driver = new Person("Hans");
        Bicycle bicycle = new Bicycle(driver, 9001, Color.BLUE);
        System.out.println(bicycle.toString());
        System.out.println(bicycle.toString2());

        Student student = new Student("Yannis");
        Bicycle bicycle2 = new Bicycle(student, 2020, Color.YELLOW);
        System.out.println(bicycle2.toString());
        System.out.println(bicycle2.toString2());
    }
}
