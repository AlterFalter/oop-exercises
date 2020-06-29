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
public class KopiererTypeA extends Kopierer {
    public KopiererTypeA(Druckwerk druckwerk, Toner toner) {
        super(druckwerk, toner, Generation.G1);
    }
}
