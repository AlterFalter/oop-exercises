/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.mepfs20;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Student
 */
public final class KopiererLager {
    private Map<String, Kopierer> gelagerteKopierer;
    
    
    public KopiererLager() {
        this.gelagerteKopierer = new HashMap<>();
        
        Druckwerk druckwerk = new Druckwerk();
        Toner toner = new Toner("red");
        Kopierer kopiererA1 = new KopiererTypeA(druckwerk, toner);
        this.gelagerteKopierer.put(kopiererA1.getSeriennummer(), kopiererA1);
        Kopierer kopiererA2 = new KopiererTypeA(druckwerk, toner);
        this.gelagerteKopierer.put(kopiererA2.getSeriennummer(), kopiererA2);
        Kopierer kopiererB1 = new KopiererTypeB(druckwerk, toner);
        this.gelagerteKopierer.put(kopiererB1.getSeriennummer(), kopiererB1);
        
        for (Map.Entry<String, Kopierer> kopiererEntry : this.gelagerteKopierer.entrySet()) {
            System.out.println(kopiererEntry.getValue().toString());
        }
    }
    
    private int getAnzahl(Generation generation) {
        return (int)this.gelagerteKopierer.entrySet().stream().map(k -> k.getValue().getGeneration()).filter(g -> g == generation).count();
    }
    
    public int getAnzahlG1() {
        return this.getAnzahl(Generation.G1);
    }
    
    public int getAnzahlG2() {
        return this.getAnzahl(Generation.G2);
    }
    
    public int getAnzahlG3() {
        return this.getAnzahl(Generation.G3);
    }
    
    public static void main(String[] args) {
        KopiererLager lager = new KopiererLager();
        
    }
}
