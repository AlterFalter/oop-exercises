/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw07.exercise1;

/**
 *
 * @author yannk
 */
public class DemoPerson {
    public static void main(String[] arg) {
        // doesn't work, incompatible types but reversed is possible
        //Student student = new Person();
        Person person = new Student();
        
        String something = "stuff " + person;
        System.out.println(something);
        System.out.println("stuff" + person.toString());
    }
    
}
