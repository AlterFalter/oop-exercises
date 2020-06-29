/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

/**
 *
 * @author Student
 */
public enum Generation {
    G1(2012),
    G2(2014),
    G3(2017);
    
    private int year;
    private Generation(int year) {
        this.year = year;
    }
    public int getYear() {
        return this.year;
    }
}
